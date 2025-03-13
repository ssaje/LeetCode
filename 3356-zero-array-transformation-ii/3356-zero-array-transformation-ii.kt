class Solution {
    fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
        fun isPossible(k: Int): Boolean {
            val diffs = IntArray(nums.size + 1)
            for (i in 0..<k) {
                val (l ,r, v) = queries[i]
                
                diffs[l] += v
                diffs[r + 1] -= v
            }

            var acc = 0
            for (i in nums.indices) {
                acc += diffs[i]
                if (nums[i] > acc) {
                    return false
                }
            }

            return true
        }   

        var l = 0
        var r = queries.size
        var answer = -1
        while (l <= r) {
            val m = l + (r - l) / 2
            if (isPossible(m)) {
                r = m - 1
                answer = m
            } else {
                l = m + 1
            }
        }

        return answer
    }
}