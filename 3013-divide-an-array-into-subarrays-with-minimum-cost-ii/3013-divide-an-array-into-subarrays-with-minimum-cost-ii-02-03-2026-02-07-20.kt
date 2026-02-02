class Solution {
    fun minimumCost(nums: IntArray, k: Int, dist: Int): Long {
        val mins = TreeMap<Int, Int>()
        val maxes = TreeMap<Int, Int>()
        var minSize = 0
        var maxSize = 0
        var sum = 0L

        val threshold = k - 2
        fun adjust() {
            while (minSize < threshold && maxes.isNotEmpty()) {
                val first = maxes.firstKey()
                mins.add(first)
                minSize++
                sum += first

                maxes.erase(first)
                maxSize--
            }

            while (minSize > threshold) {
                val last = mins.lastKey()
                maxes.add(last)
                maxSize++

                mins.erase(last)
                minSize--
                sum -= last
            }
        }

        fun add(num: Int) {
            if (maxes.isNotEmpty() && maxes.firstKey() <= num) {
                maxes.add(num)
                maxSize++
            } else {
                mins.add(num)
                minSize++
                sum += num
            }

            adjust()
        }

        for (i in 1..<k-1) {
            add(nums[i])
        }

        fun erase(num: Int) {
            if (num in mins) {
                mins.erase(num)
                minSize--
                sum -= num
            } else {
                maxes.erase(num)
                maxSize--
            }

            adjust()
        }

        var answer = sum + nums[k - 1]
        for (i in k..<nums.size) {
            val j = i - dist - 1
            if (j > 0) erase(nums[j])

            add(nums[i - 1])
            answer = minOf(answer, sum + nums[i])
        }

        return nums[0] + answer
    }

    private fun TreeMap<Int, Int>.add(key: Int) = put(key, getOrDefault(key, 0) + 1)

    private fun TreeMap<Int, Int>.erase(key: Int) {
        val count = this[key] ?: return
        if (count == 1) remove(key)
        else put(key, count - 1)
    }
}