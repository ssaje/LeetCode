class Solution {
    fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
        var answer = 0
        for (i in arr.indices) {
            for (j in i+1..<arr.size) {
                for (k in j+1..<arr.size) {
                    if (
                        abs(arr[i] - arr[j]) <= a &&
                        abs(arr[j] - arr[k]) <= b &&
                        abs(arr[i] - arr[k]) <= c
                    ) {
                        answer++
                    }
                }
            }
        }

        return answer
    }
}