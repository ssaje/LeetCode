class Solution {
    fun minOperations(boxes: String): IntArray {
        val answer = IntArray(boxes.length)
        for (i in boxes.indices) {
            for (j in boxes.indices) {
                if (i == j) {
                    continue
                }

                answer[i] += (boxes[j] - '0') * (i - j).absoluteValue
            }
        }

        return answer
    }
}