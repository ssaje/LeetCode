class Solution {
    fun maximumScore(nums: List<Int>, k: Int): Int {
        val n = nums.size
        val primeScores = IntArray(n) { primeScore(nums[it]) }

        val deque = ArrayDeque<Int>()
        val lefts = IntArray(n) { -1 }
        val rights = IntArray(n) { n }

        // leftScore < score &&  score <= rightScore => score selected
        for (i in 0..<n) {
            val score = primeScores[i]
            while (deque.isNotEmpty() && primeScores[deque.last()] < score) {
                rights[deque.removeLast()] = i
            }

            if (deque.isNotEmpty()) {
                lefts[i] = deque.last()
            }

            deque.addLast(i)
        }

        val pq = PriorityQueue<IndexedValue<Int>> { a, b ->
            if (a.value == b.value) {
                a.index - b.index
            } else {
                b.value - a.value
            }
        }

        nums.withIndex().forEach(pq::offer)
        var answer = 1L
        var remained = k.toLong()
        while (remained > 0) {
            val (index, value) = pq.poll()
            val operations = minOf(remained, (index - lefts[index]).toLong() * (rights[index] - index))
            answer = (answer * exp(value, operations)) % MOD
            remained -= operations
        }

        return answer.toInt()
    }

    private fun primeScore(num: Int): Int {
        if (num == 1) {
            return 0
        }

        var score = 0
        var current = num
        if (current % 2 == 0) {
            score++

            do {
                current /= 2
            } while (current % 2 == 0)
        }

        var factor = 3
        var threshold = sqrt(num.toDouble()).toInt()
        while (current > 1 && factor <= threshold) {
            if (current % factor == 0) {
                score++

                do {
                    current /= factor
                } while (current % factor == 0)
            }

            factor += 2
        }

        if (current >= 2) {
            score++
        }

        return score
    }

    private fun exp(base: Int, power: Long): Long {
        var ret = 1L
        var b = base.toLong()
        var p = power
        while (p > 0) {
            if (p and 1 == 1L) {
                ret = (ret * b) % MOD
            }

            b = (b * b) % MOD
            p = p shr 1
        }

        return ret
    }

    companion object {
        private const val MOD = 1_000_000_000 + 7
    }
}