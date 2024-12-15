class Solution {
    fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
        // a/b -> a+1/b+1
        // {(a+1)b - a(b+1)}/{b(b+1)}
        val pq = PriorityQueue<Pair<Long, Long>> { a, b ->
            (a.second * (a.second + 1) * ((b.first + 1) * b.second - b.first * (b.second + 1))).compareTo(b.second * (b.second + 1) * ((a.first + 1) * a.second - (a.first * (a.second + 1))))
        }

        classes.forEach { (pass, total) -> pq.offer(pass.toLong() to total.toLong()) }

        repeat(extraStudents) {
            val (a, b) = pq.poll()
            pq.offer(a + 1 to b + 1)
        }

        var sum = 0.0
        while (pq.isNotEmpty()) {
            val (pass, total) = pq.poll()
            sum += pass.toDouble() / total
        }

        return sum / classes.size
    }
}