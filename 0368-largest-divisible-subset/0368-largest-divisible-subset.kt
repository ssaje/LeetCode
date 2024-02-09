class Solution {
    fun largestDivisibleSubset(nums: IntArray): List<Int> {
        val sorted = nums.sorted()
        val d = IntArray(nums.size)
        val prev = IntArray(nums.size) { -1 }
        d[0] = 1
        
        var index = 0
        for (i in 1..sorted.lastIndex) {
            val num = sorted[i]
            for (j in 0..< i) {
                if (num % sorted[j] != 0) {
                    continue
                }

                if (d[i] < d[j]) {
                    d[i] = d[j]
                    prev[i] = j
                }                
            }

            d[i]++
            if (d[index] < d[i]) {
                index = i
            }
        }

        val answer = mutableListOf<Int>()
        while (index != -1) {
            answer += sorted[index]
            index = prev[index]
        }

        return answer
    }
}