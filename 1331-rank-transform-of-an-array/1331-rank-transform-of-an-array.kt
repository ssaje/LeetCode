class Solution {
    fun arrayRankTransform(arr: IntArray): IntArray {
        val sorted = arr.sorted()
        val ranks = mutableMapOf<Int, Int>()
        
        var count = 0
        sorted.forEach {
            if (it !in ranks) {
                ranks[it] = ++count
            }
        }

        return arr.map { ranks[it]!! }.toIntArray()
    }
}