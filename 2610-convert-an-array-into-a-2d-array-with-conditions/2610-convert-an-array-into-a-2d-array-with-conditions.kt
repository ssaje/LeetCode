class Solution {
    fun findMatrix(nums: IntArray): List<List<Int>> {
        var max = 0
        val sorted = IntArray(nums.size + 1)
        for (num in nums) {
            sorted[num]++
            if (max < num) {
                max = num
            }
        }

        val answer = mutableListOf<List<Int>>()
        var rest = nums.size
        while (rest > 0) {
            val row = mutableListOf<Int>()
            for (i in 1..max) {
                if (sorted[i] > 0) {
                    sorted[i]--
                    row += i
                }
            }

            answer += row
            rest -= row.size
        }

        return answer
    }
}