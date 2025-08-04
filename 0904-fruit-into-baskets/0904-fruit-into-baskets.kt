class Solution {
    fun totalFruit(fruits: IntArray): Int {
        val n = fruits.size
        val counts = IntArray(n)
        var count = 0
        var l = 0
        var answer = 0
        for (r in 0..<n) {
            if (++counts[fruits[r]] == 1) {
                count++
            }

            while (count > 2) {
                if(--counts[fruits[l]] == 0) {
                    count--
                }

                l++
            }

            answer = maxOf(answer, r - l + 1)
        }

        return answer
    }
}