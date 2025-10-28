class Solution {
    fun countValidSelections(nums: IntArray): Int {
        val n = nums.size
        val sufs = IntArray(n)
        sufs[n - 1] = nums[n - 1]
        for (i in n-2 downTo 0) {
            sufs[i] = sufs[i + 1] + nums[i]
        }

        var answer = 0
        var pre = 0
        for (i in 0..<n) {
            pre += nums[i]
            if (nums[i] != 0) continue

            if (pre == sufs[i]) answer += 2
            else if (pre == sufs[i] + 1 || pre + 1 == sufs[i]) answer++
        }

        return answer
    }
}