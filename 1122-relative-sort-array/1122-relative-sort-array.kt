class Solution {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        val counts = IntArray(1001)
        for (element in arr1) {
            counts[element]++
        }

        val answer = IntArray(arr1.size)
        var i = 0
        for (element in arr2) {
            while (counts[element] > 0) {
                counts[element]--
                answer[i++] = element
            }
        }

        for ((index, count) in counts.withIndex()) {
            repeat(count) {
                answer[i++] = index
            }
        }

        return answer
    }
}