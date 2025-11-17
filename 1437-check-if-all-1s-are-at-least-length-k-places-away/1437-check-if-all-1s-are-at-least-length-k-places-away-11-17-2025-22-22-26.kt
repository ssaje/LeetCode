class Solution {
    fun kLengthApart(nums: IntArray, k: Int): Boolean {
        var distance = 0
        var one = false
        for (num in nums) {
            if (num == 0) distance++
            else {
                if (one && distance < k) return false
                one = true
                distance = 0
            }
        }

        return true
    }
}