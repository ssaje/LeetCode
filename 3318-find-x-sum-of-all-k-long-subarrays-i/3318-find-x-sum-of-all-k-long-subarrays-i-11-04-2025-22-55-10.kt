class Solution {
    fun findXSum(nums: IntArray, k: Int, x: Int): IntArray {
        fun xSum(range: IntRange): Int {
            var sum = 0        
            val counts = IntArray(51)
            for (num in nums.slice(range)) {
                counts[num]++
            }

            counts.withIndex().sortedWith(
                compareByDescending<IndexedValue<Int>> { it.value }
                    .thenByDescending { it.index }
            ).take(x).forEach { (index, value) ->
                sum += index * value
            }

            return sum
        }   

        val n = nums.size
        val answer = IntArray(n - k + 1)
        for (i in 0..<n-k+1) {
            answer[i] = xSum(i..<i+k)
        }

        return answer
    }
}