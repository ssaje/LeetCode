class FindSumPairs(private val nums1: IntArray, nums2: IntArray) {
    private val nums = IntArray(nums2.size) { nums2[it] }
    private val counts = mutableMapOf<Int, Int>()
    
    init {
        for (num in nums2) {
            counts[num] = (counts[num] ?: 0) + 1
        }
    }

    fun add(index: Int, `val`: Int) {
        val num = nums[index]
        counts[num] = counts[num]!! - 1
        
        val added = num + `val`
        counts[added] = (counts[added] ?: 0) + 1
        nums[index] = added
    }

    fun count(tot: Int): Int {
        var sum = 0
        for (num in nums1) {
            if (tot < num) continue
            sum += counts[tot - num] ?: 0
        }

        return sum
    }

}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * var obj = FindSumPairs(nums1, nums2)
 * obj.add(index,`val`)
 * var param_2 = obj.count(tot)
 */