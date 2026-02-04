class Solution {
    fun maxSumTrionic(nums: IntArray): Long {
        val n = nums.size
        
        fun increasing(start: Int): Int {
            var end = start + 1
            while (end < n) {
                if (nums[end - 1] >= nums[end]) {
                    break
                }

                end++
            }
            
            return end - 1
        }

        fun decreasing(start: Int): Int {
            var end = start + 1
            while (end < n) {
                if (nums[end - 1] <= nums[end]) {
                    break
                }

                end++
            }
            
            return end - 1
        }

        val incs = IntArray(n) { it }
        var i = 0
        while (i < n) {
            val j = increasing(i)
            for (k in i..<j) {
                incs[k] = j
            }
            
            i = j + 1
        }

        val decs = IntArray(n) { it }
        i = 0
        while (i < n) {
            val j = decreasing(i)
            for (k in i..<j) {
                decs[k] = j
            }
            
            i = j + 1
        }

        val sums = LongArray(n)
        sums[0] = nums[0].toLong()
        for (i in 1..<n) {
            sums[i] = sums[i - 1] + nums[i]
        }

        val lSums = LongArray(n)
        lSums[0] = nums[0].toLong()
        for (i in 1..<n) {
            if (nums[i - 1] < nums[i]) {
                lSums[i] = nums[i] + lSums[i - 1].coerceAtLeast(0)
            } else {
                lSums[i] = nums[i].toLong()
            }
        }

        val rSums = LongArray(n)
        rSums[n-1] = nums[n-1].toLong()
        for (i in n-2 downTo 0) {
            if (nums[i] < nums[i + 1]) {
                rSums[i] = nums[i] + rSums[i + 1].coerceAtLeast(0)   
            } else {
                rSums[i] = nums[i].toLong()
            }
        }

        // i d i
        var l = 0
        var answer = Long.MIN_VALUE
        while (l < n) {
            val p = incs[l]
            if (p == l) {
                l = p + 1
                continue
            }

            val q = decs[p]
            if (q == p) {
                l = q + 1
                continue
            }

            val r = incs[q]
            if (r == q) {
                l = r + 1
                continue
            }

            // l < p < q < r
            val lSum = lSums[p - 1]
            val mSum = sums[q] - sums[p - 1]
            val rSum = rSums[q + 1]

            answer = maxOf(answer, lSum + mSum + rSum)
            l = q
        }

        return answer
    }
}