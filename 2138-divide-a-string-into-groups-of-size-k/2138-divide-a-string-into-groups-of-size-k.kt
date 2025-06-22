class Solution {
    fun divideString(s: String, k: Int, fill: Char): Array<String> {
        val answer = Array((s.length + k - 1) / k) { "" }
        var i = 0
        while (i < s.length) {
            answer[i / k] = s.slice(i..<minOf(i+k, s.length)).padEnd(k, fill)
            i += k
        }

        return answer
    }
}