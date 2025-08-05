class Solution {
    fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
        val used = BooleanArray(fruits.size)
        var answer = 0
        for (fruit in fruits) {
            var i = 0
            while (i < baskets.size) {
                if (!used[i] && fruit <= baskets[i]) {
                    used[i] = true
                    break
                }

                i++
            }

            if (i == baskets.size) {
                answer++
            }
        }

        return answer
    }
}