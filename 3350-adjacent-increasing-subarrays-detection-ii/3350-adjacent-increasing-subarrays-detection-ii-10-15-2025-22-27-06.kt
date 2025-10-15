class Solution {
    fun maxIncreasingSubarrays(nums: List<Int>): Int {
        val n = nums.size

        fun max(s: Int): Int {
            if (s == n) return 0

            var i = s + 1
            var count = 1
            while (i < n) {
                if (nums[i - 1] >= nums[i]) break
                count++
                i++
            }

            return count
        }

        var previousCount = max(0)
        var answer = previousCount / 2
        var i = previousCount
        while (i < n) {
            val count = max(i)
            answer = maxOf(answer, minOf(previousCount, count), count / 2)
            println("$i $count")
            previousCount = count
            i += count
        }

        return answer
    }
}