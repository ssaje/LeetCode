class Solution {
    fun specialArray(nums: IntArray): Int {
        for (x in 0..nums.size) {
            var count = 0
            for (num in nums) {
                if (x <= num) {
                    ++count
                }
            }

            if (count == x) {
                return x
            }
        }   

        return -1
    }
}