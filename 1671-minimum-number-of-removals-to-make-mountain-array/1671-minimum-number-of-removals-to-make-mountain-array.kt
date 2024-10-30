class Solution {
    fun minimumMountainRemovals(nums: IntArray): Int {
        val n = nums.size
        val incs = IntArray(n)
        val decs = IntArray(n)

        for (i in 0..<n) {
            for (j in 0..<i) {
                if (nums[j] < nums[i]) {
                    incs[i] = incs[i].coerceAtLeast(incs[j])
                }
            }

            incs[i]++
        }

        for (i in n-1 downTo 0) {
            for (j in i..<n) {
                if (nums[j] < nums[i]) {
                    decs[i] = decs[i].coerceAtLeast(decs[j])
                }
            }

            decs[i]++
        }

        var answer = n
        for (i in 0..<n) {
            if (incs[i] > 1 && decs[i] > 1) {
                answer = answer.coerceAtMost(n + 1 - incs[i] - decs[i])
            }
        }

        return answer
    }
}