class Solution {
    fun lenLongestFibSubseq(arr: IntArray): Int {
        val n = arr.size
        val cached = Array(n) { IntArray(n) }
        var answer = 0
        for (i in 2..<n) {
            var s = 0
            var e = i - 1
            while (s < e) {
                if (arr[s] + arr[e] == arr[i]) {
                    cached[e][i] = cached[s][e] + 1
                    answer = maxOf(answer, cached[e][i])
                    s++
                    e--
                } else if (arr[s] + arr[e] > arr[i]) {
                    e--
                } else {
                    s++
                }
            }
        }

        return if (answer == 0) {
            0
        } else {
            answer + 2
        }
    }
}