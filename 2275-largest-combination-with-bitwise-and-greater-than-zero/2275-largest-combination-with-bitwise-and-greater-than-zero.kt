class Solution {
    fun largestCombination(candidates: IntArray): Int {
        var w = 1
        var answer = 0
        while (w <= 10_000_000) {
            val count = candidates.count { it and w > 0 }
            if (answer < count) {
                answer = count
            }

            w = w shl 1
        }

        return answer
    }
}