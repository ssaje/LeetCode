class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        var subsets = mutableListOf<List<Int>>()
        
        fun solve(index: Int, subset: MutableList<Int>) {
            if (index == nums.size) {
                subsets += ArrayList(subset)
                return
            }

            solve(index + 1, subset)

            subset += nums[index]
            solve(index + 1, subset)
            subset.removeLast()
        }

        solve(0, mutableListOf())

        return subsets
    }
}