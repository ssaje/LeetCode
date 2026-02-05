class Solution {
    fun constructTransformedArray(nums: IntArray): IntArray {
        val n = nums.size
        val answer = IntArray(n)
        for (i in 0..<n) {
            val rem = nums[i].absoluteValue % n
            if (nums[i] > 0) answer[i] = nums[(i + rem) % n]
            else if (nums[i] == 0) answer[i] = nums[i]
            else answer[i] = nums[(i - rem + n) % n]
        }

        return answer
    }
}