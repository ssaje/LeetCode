class Solution {
    fun lexicographicallySmallestArray(nums: IntArray, limit: Int): IntArray {
        val sorted = nums.sorted()
        val numsByGroup: MutableList<ArrayDeque<Int>> = mutableListOf(ArrayDeque(listOf(sorted[0])))
        val groupsByNum = mutableMapOf<Int, Int>().apply {
            this[sorted[0]] = 0
        }

        var groupCount = 0
        for (i in 1..sorted.lastIndex) {
            if (sorted[i] - sorted[i - 1] > limit) {
                groupCount++
            }

            groupsByNum[sorted[i]] = groupCount

            if (numsByGroup.size == groupCount) {
                numsByGroup.add(ArrayDeque())
            }

            numsByGroup[groupCount]!!.addLast(sorted[i])
        }

        val answer = IntArray(nums.size)
        for (i in 0..nums.lastIndex) {
            val group = groupsByNum[nums[i]]!!
            answer[i] = numsByGroup[group].removeFirst()
        }

        return answer
    }
}