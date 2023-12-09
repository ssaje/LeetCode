class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val duplicates = HashSet<Int>()
        for (num in nums) {
            if (num in duplicates) {
                return true
            }

            duplicates.add(num)
        }

        return false
    }
}