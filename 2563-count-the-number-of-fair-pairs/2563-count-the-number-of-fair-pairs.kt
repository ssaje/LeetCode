class Solution {
    fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
        val sorted = nums.sorted()
        var answer = 0L

        fun getLowerBound(i: Int, target: Int): Int? {
            var lowerBound: Int? = null
            var l = 0
            var r = i - 1
            while (l <= r) {
                val m = l + (r - l) / 2
                if (sorted[m] < target) {
                    l = m + 1
                } else {
                    r = m - 1
                    lowerBound = m
                }
            }

            return lowerBound
        }

        fun getUpperBound(i: Int, target: Int): Int? {
            var upperBound: Int? = null
            var l = 0
            var r = i - 1
            while (l <= r) {
                val m = l + (r - l) / 2
                if (sorted[m] > target) {
                    r = m - 1
                } else {
                    l = m + 1
                    upperBound = m
                }
            }

            return upperBound
        }

        for (i in 1..sorted.lastIndex) {
            val lowerBound = getLowerBound(i, lower - sorted[i]) ?: continue
            val upperBound = getUpperBound(i, upper - sorted[i]) ?: continue

            if (lowerBound > upperBound) {
                continue
            }

            println("$lowerBound $upperBound $i")

            answer += upperBound - lowerBound + 1
        }   

        // 1 2 5 7 9
        // 0 1 2 3 4

        return answer
    }
}