class Solution {
    fun maxSubarrayLength(nums: IntArray, k: Int): Int {
        var answer = 0
        var s = 0
        var frequenciesByNum = mutableMapOf<Int, Int>()
        for (e in nums.indices) {
            val num = nums[e]
            frequenciesByNum[num]  = (frequenciesByNum[num] ?: 0) + 1
            
            while (frequenciesByNum[num]!! > k && s <= e) {
                val prev = nums[s]
                frequenciesByNum[prev]  = frequenciesByNum[prev]!! - 1
                s++
            }

            answer = answer.coerceAtLeast(e - s + 1)
        }

        return answer   
    }
}