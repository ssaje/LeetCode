class Solution {
    fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
        val d = IntArray(arr.size + 1)
        for (i in 1..arr.size) {
            var max = 0
            for (j in 1..k.coerceAtMost(i)) {
                if (max < arr[i - j]) {
                    max = arr[i - j]
                }

                if (d[i] < d[i - j] + max * j) {
                    d[i] = d[i - j] + max * j
                }
            }
        }

        return d.last()
    }
}