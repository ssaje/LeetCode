class Solution {
    fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
        val sorted = nums.sorted()
        val count = nums.size / 3
        var answer = Array(count) { sorted.slice(3*it..<3*(it+1)).toIntArray() }
        for (i in 0..<count) {
            if (answer[i][2] - answer[i][0] > k) return arrayOf()
        }

        return answer
    }
}