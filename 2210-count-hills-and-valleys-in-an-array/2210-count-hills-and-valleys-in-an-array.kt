class Solution {
    fun countHillValley(nums: IntArray): Int {
        val distinct = nums.distinct()
        if (distinct.size < 3) return 0

        var answer = 0
        for (i in 1..<distinct.size-1) {
            if (distinct[i - 1] < distinct[i] && distinct[i] > distinct[i + 1]) answer++
            else if (distinct[i - 1] > distinct[i] && distinct[i] < distinct[i + 1]) answer++
        }

        return answer
    }
}