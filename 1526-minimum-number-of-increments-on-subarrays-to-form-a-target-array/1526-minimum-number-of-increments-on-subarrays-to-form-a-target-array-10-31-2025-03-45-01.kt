class Solution {
    fun minNumberOperations(target: IntArray): Int {
        val n = target.size
        var answer = target[0]
        for (i in 1..<n) {
            answer += maxOf(0, target[i] - target[i - 1])
        }
        
        return answer
    }
}