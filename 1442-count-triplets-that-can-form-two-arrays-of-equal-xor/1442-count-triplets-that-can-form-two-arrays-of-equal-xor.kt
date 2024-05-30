class Solution {
    fun countTriplets(arr: IntArray): Int {
        var answer = 0
        var acc = 0
        for (i in arr.indices) {
            acc = acc xor arr[i]

            var prev = 0
            for (j in 0..<i) {
                if (prev == acc) {
                    answer += i - j
                }

                prev = prev xor arr[j]
            }
        }


        return answer
    }
}