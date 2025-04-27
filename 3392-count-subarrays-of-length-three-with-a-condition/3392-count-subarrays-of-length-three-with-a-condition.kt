class Solution {
    fun countSubarrays(nums: IntArray): Int {
        var answer = 0
        for (i in 1..<nums.size-1) {
            if ((nums[i - 1] + nums[i + 1]) * 2 == nums[i]) {
                answer++
            }
        }   

        return answer
    }
}