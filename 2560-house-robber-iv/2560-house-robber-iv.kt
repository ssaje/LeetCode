class Solution {
    fun minCapability(nums: IntArray, k: Int): Int {
        fun isPossible(cap: Int): Boolean {
            var count = 0
            var i = 0
            while (i < nums.size) {
                if (nums[i] <= cap) {
                    count++
                    if (count >= k) {
                        return true
                    }
                    i += 2
                } else {
                    i++
                }
            }

            return false
        }

        var answer = 0
        var l = 0
        var r = 0
        for (num in nums) {
            r = maxOf(r, num)
        }

        while (l <= r) {
            val m = l + (r - l) / 2
            if (isPossible(m)) {
                answer = m
                r = m - 1
            } else {
                l = m + 1
            }
        }

        return answer
    }
}