class Solution {
    fun minimumDifference(nums: IntArray): Long {
        val n = nums.size / 3

        val firsts = PriorityQueue<Int>(Comparator.reverseOrder())
        var firstSum = 0L
        for (i in 0..<n) {
            val num = nums[i]
            firsts.offer(num)
            firstSum += num
        }

        val seconds = PriorityQueue<Int>()
        var secondSum = 0L
        for (i in 2*n..<3*n) {
            val num = nums[i]
            seconds.offer(num)
            secondSum += num
        }

        val lefts = LongArray(3*n)
        for (i in n..<2*n) {
            lefts[i] = lefts[i - 1]
            if (firsts.peek() > nums[i]) {
                lefts[i] += nums[i] - firsts.poll()
                firsts.offer(nums[i])
            }
        }
        
        val rights = LongArray(3*n)
        for (i in 2*n-1 downTo n) {
            rights[i] = rights[i + 1]
            if (seconds.peek() < nums[i]) {
                rights[i] += nums[i] - seconds.poll()
                seconds.offer(nums[i])
            }
        }

        var delta = lefts[n - 1] - rights[n]
        for (i in n..<2*n) {
            delta = minOf(delta, lefts[i] - rights[i + 1])
        }

        return delta + firstSum - secondSum
    }
}