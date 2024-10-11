class Solution {
    fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
        val pq = PriorityQueue<Int>()
        val chairs = IntArray(times.size)
        
        var last = 0
        (0..times.lastIndex)
            .flatMap {
                listOf(
                    Triple(it, times[it][0], true),
                    Triple(it, times[it][1], false),
                )
            }
            .sortedWith(
                compareBy(
                    { it.second },
                    { it.third },
                )
            )
            .forEach {
                if (!it.third) {
                    pq.offer(chairs[it.first])
                    return@forEach
                }

                if (pq.isEmpty()) {
                    pq.offer(last++)
                }

                chairs[it.first] = pq.poll()
                if (it.first == targetFriend) {
                    return chairs[it.first]
                }
            }

        return -1
    }
}