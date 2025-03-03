class Solution {
    fun pivotArray(nums: IntArray, pivot: Int): IntArray {
        val answer = IntArray(nums.size)
        var count = 0
        val bigs = mutableListOf<Int>()
        
        var i = 0
        for (num in nums) {
            if (num == pivot) {
                count++
            } else if (num > pivot) {
                bigs += num
            } else {
                answer[i++] = num
            }
        }

        repeat(count) {
            answer[i++] = pivot
        }

        for (big in bigs) {
            answer[i++] = big
        }

        return answer
    }
}