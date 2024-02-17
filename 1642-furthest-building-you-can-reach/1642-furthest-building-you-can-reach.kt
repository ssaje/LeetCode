class Solution {
    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        val pq = PriorityQueue<Int>(Collections.reverseOrder())
        var sum = 0
        var remainingLadders = ladders
        for (i in 1..heights.lastIndex) {
            val diff = heights[i] - heights[i - 1]
            if (diff <= 0) {
                continue
            }

            pq.add(diff)
            sum += diff

            while (sum > bricks) {
                if (remainingLadders == 0) {
                    return i - 1
                }

                val max = pq.remove()
                sum -= max
                --remainingLadders
            }
        }

        return heights.lastIndex
    }
}