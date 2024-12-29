class Solution {
    fun maxSumOfThreeSubarrays(nums: IntArray, k: Int): IntArray {
        val sums = intArrayOf(0, 0, 0, 0)
        val totalSums = intArrayOf(0, 0, 0, 0)
        val indexes = intArrayOf(0, 0, k, 2*k)

        for (i in 1..3) {
            sums[i] = nums.drop(indexes[i]).take(k).sum()
            totalSums[i] = sums[i] + totalSums[i - 1]
        }

        val bestIndexes = Array(4) { intArrayOf(0, 0, k, 2*k) }

        while (indexes[3] + k < nums.size) {
            for (i in 1..3) {
                sums[i] += nums[indexes[i] + k] - nums[indexes[i]]
                indexes[i]++

                if (totalSums[i] < totalSums[i - 1] + sums[i]) {
                    totalSums[i] = totalSums[i - 1] + sums[i]

                    for (j in 1..<i) {
                        bestIndexes[i][j] = bestIndexes[i - 1][j]
                    }

                    bestIndexes[i][i] = indexes[i]
                }
            }
        }

        return bestIndexes[3].drop(1).toIntArray()
    }
}