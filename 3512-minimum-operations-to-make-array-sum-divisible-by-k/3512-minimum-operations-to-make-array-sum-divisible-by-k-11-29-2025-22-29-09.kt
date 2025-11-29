class Solution {
    fun minOperations(nums: IntArray, k: Int): Int {
        return nums.sum() % k
    }
}