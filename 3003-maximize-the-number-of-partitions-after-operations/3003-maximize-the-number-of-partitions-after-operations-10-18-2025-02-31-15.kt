class Solution {
    fun maxPartitionsAfterOperations(s: String, k: Int): Int {
        if (k == 26) return 1

        val n = s.length

        // [0, i)
        val left = Array(n) { IntArray(3) }
        var partition = 0
        var mask = 0
        var count = 0
        for (i in 0..<n-1) {
            val bit = 1 shl (s[i] - 'a')
            if ((bit and mask) == 0) {
                count++
                if (count <= k) {
                    mask = mask or bit
                } else {
                    partition++
                    mask = bit
                    count = 1
                }
            }

            left[i + 1][0] = partition
            left[i + 1][1] = mask
            left[i + 1][2] = count
        }

        // (i, n)
        val right = Array(n) { IntArray(3) }
        partition = 0
        mask = 0
        count = 0
        for (i in n-1 downTo 1) {
            val bit = 1 shl (s[i] - 'a')
            if ((bit and mask) == 0) {
                count++
                if (count <= k) {
                    mask = mask or bit
                } else {
                    partition++
                    mask = bit
                    count = 1
                }
            }

            right[i - 1][0] = partition
            right[i - 1][1] = mask
            right[i - 1][2] = count
        }

        var answer = 0
        for (i in 0..<n) {
            var totalPartition = left[i][0] + right[i][0] + 2
            val totalMask = left[i][1] or right[i][1]
            val totalCount = totalMask.countOneBits()
            if (left[i][2] == k && right[i][2] == k && totalCount < 26) {
                totalPartition++
            } else if (minOf(26, totalCount + 1) <= k) {
                totalPartition--
            }

            answer = maxOf(answer, totalPartition)
        }

        return answer
    }
}