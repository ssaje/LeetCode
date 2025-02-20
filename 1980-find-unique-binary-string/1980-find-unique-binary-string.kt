class Solution {
    fun findDifferentBinaryString(nums: Array<String>): String {
        val sorted = nums.sorted()
        val n = nums[0].length
        var m = 0
        for (num in sorted) {
            val str = m.toString(2).padStart(n, '0')
            if (str != num) {
                return str
            }

            m++
        }

        return m.toString(2).padStart(n, '0')
    }
}