class Solution {
    fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
        // 1/5 1/3 1/2
        // 2/5 2/3
        // 3/5

        val pq = PriorityQueue<Pair<Int, Int>>() { a, b ->
            arr[a.first] * arr[b.second] - arr[a.second] * arr[b.first]
        }

        for (i in 0..<arr.lastIndex) {
            pq.offer(i to arr.lastIndex)
        }

        repeat(k) {
            val (num, denom) = pq.poll()
            if (it + 1 == k) {
                return intArrayOf(arr[num], arr[denom])
            }

            if (num + 1 < denom) {
                pq.offer(num to denom - 1)
            }
        }

        return intArrayOf()
    }
}