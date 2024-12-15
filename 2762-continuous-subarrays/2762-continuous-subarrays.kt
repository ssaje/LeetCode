class Solution {
    fun continuousSubarrays(nums: IntArray): Long {
        // (value, index)
        val minimums = PriorityQueue<Pair<Int, Int>> { a, b ->
            if (a.first != b.first) {
                a.first.compareTo(b.first)
            } else {
                a.second.compareTo(b.second)
            }
        }

        // (value, index)
        val maximums = PriorityQueue<Pair<Int, Int>> { a, b ->
            if (a.first != b.first) {
                b.first.compareTo(a.first)
            } else {
                a.second.compareTo(b.second)
            }
        }

        var s = 0
        var answer = 0L
        for (e in nums.indices) {
            val num = nums[e]
            while (minimums.isNotEmpty() && minimums.peek().first < num - 2) {
                s = s.coerceAtLeast(minimums.poll().second + 1)
            }

            while (maximums.isNotEmpty() && maximums.peek().first > num + 2) {
                s = s.coerceAtLeast(maximums.poll().second + 1)
            }

            minimums.offer(num to e)
            maximums.offer(num to e)

            answer += e - s + 1
        }

        return answer
    }
}