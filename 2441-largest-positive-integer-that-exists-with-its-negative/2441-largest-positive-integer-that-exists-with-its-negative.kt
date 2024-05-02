class Solution {
    fun findMaxK(nums: IntArray): Int {
        val set = HashSet<Int>()
        var answer = -1001
        for (num in nums) {
            set.add(num)
            if (-num in set && answer < num.absoluteValue) {
                answer = num.absoluteValue
            }
        }

        return if (answer == -1001) -1 else answer
    }
}