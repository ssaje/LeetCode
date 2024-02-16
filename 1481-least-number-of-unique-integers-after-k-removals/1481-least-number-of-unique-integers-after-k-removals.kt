class Solution {
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
        val sumsByInteger = arr
            .asSequence()
            .groupingBy { it }
            .eachCount()
            .toList()
            .sortedBy { it.second }

        var currentSum = 0
        for (i in sumsByInteger.indices) {
            currentSum += sumsByInteger[i].second
            if (currentSum == k) {
                return sumsByInteger.lastIndex - i
            } else if (currentSum > k) {
                return sumsByInteger.size - i
            }
        }

        return 0
    }
}