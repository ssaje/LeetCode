class Solution {
    fun lengthAfterTransformations(s: String, t: Int, nums: List<Int>): Int {
        fun pow(a: Transformation, b: Int): Transformation {
            if (b == 1) return a
            
            return if (b % 2 == 0) {
                val res = pow(a, b / 2)
                res * res
            } else {
                a * pow(a, b - 1)
            }
        }

        val counts = IntArray(26)
        for (ch in s) {
            counts[ch - 'a']++
        }

        val transformation = pow(Transformation(nums), t)
        var answer = 0L
        for (i in 0..<26) {
            for (j in 0..<26) {
                answer = (answer + transformation.matrix[i][j] * counts[j]) % MOD
            }
        }

        return answer.toInt()
    }

    private class Transformation private constructor(
        val matrix: Array<LongArray> = Array(26) { LongArray(26) },
    ) {
        constructor(nums: List<Int>) : this() {
            for (i in nums.indices) {
                val num = nums[i]
                for (j in i+1..i+num) {
                    val k = j % 26
                    matrix[k][i]++
                }
            }   
        }

        operator fun times(other: Transformation): Transformation {
            val res = Transformation()
            for (i in 0..<26) {
                for (j in 0..<26) {
                    for (k in 0..<26) {
                        res.matrix[i][k] = (res.matrix[i][k] + matrix[i][j] * other.matrix[j][k]) % MOD
                    }
                }
            }

            return res
        }
    }

    companion object {
        private const val MOD = 1_000_000_000 + 7
    }
}