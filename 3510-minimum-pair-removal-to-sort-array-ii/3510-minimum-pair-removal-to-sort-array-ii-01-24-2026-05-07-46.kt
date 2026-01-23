class Solution {
    fun minimumPairRemoval(nums: IntArray): Int {
        val n = nums.size

        // sum, index
        val pq = PriorityQueue<Pair<Long, Int>> { a, b ->
            if (a.first != b.first) a.first.compareTo(b.first)
            else a.second - b.second
        }

        var dec = 0
        for (i in 1..<n) {
            if (nums[i - 1] > nums[i]) dec++
            pq.offer((nums[i - 1] + nums[i]).toLong() to (i - 1))
        }

        val sums = LongArray(n) { nums[it].toLong() }
        val prevs = IntArray(n) { -1 + it }
        val nexts = IntArray(n) { 1 + it }
        
        var answer = 0
        while (dec > 0) {
            val (sum, i) = pq.poll()
            val next = nexts[i]
            if (next == n || sum != sums[i] + sums[next]) continue

            nexts[i] = nexts[next]
            if (nexts[i] != n) prevs[nexts[i]] = i

            nexts[next] = -1
            prevs[next] = -1

            val prev = prevs[i]
            if (prev != -1 && sums[prev] > sums[i]) dec--
            if (sums[i] > sums[next]) dec--
            if (nexts[i] != n && sums[next] > sums[nexts[i]]) dec--

            sums[i] += sums[next]

            if (prev != -1) {
                if (sums[prev] > sums[i]) dec++
                pq.offer((sums[prev] + sums[i]) to prev)
            }

            if (nexts[i] != n) {
                if (sums[i] > sums[nexts[i]]) dec++
                pq.offer((sums[i] + sums[nexts[i]]) to i)
            }

            answer++
        }

        return answer
    }
}