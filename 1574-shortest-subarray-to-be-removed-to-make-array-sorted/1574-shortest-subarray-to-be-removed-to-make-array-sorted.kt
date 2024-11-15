class Solution {
    fun findLengthOfShortestSubarray(arr: IntArray): Int {
        var r = arr.lastIndex
        while (r > 0 && arr[r - 1] <= arr[r]) {
            r--
        }

        var answer = r
        var l = 0
        while (l < r && (l == 0 || arr[l - 1] <= arr[l])) {
            while (r < arr.size && arr[l] > arr[r]) {
                r++
            }

            answer = answer.coerceAtMost(r - l - 1)
            l++
        }

        return answer
    }
}