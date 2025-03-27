class Solution {
    fun minimumIndex(nums: List<Int>): Int {
        var dominant = 0
        var count = 0
        for (num in nums) {
            if (dominant == num) {
                count++
            } else if (count == 0) {
                dominant = num
                count = 1
            } else {
                count--
            }
        }

        val total = nums.count { it == dominant }
        var acc = 0
        for (i in 0..<nums.size) {
            acc += if (nums[i] == dominant) 1 else 0
            if (acc > (i + 1) / 2 && total - acc > (nums.size - i - 1) / 2) {
                return i
            }
        }

        return -1
    }
}