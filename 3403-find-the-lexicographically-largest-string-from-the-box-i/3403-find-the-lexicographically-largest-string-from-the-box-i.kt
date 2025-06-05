class Solution {
    fun answerString(word: String, numFriends: Int): String {
        if (numFriends == 1) return word

        var limit = word.length - (numFriends - 1)
        var answer = ""
        for (i in 0..<word.length) {
            val j = minOf(word.length, i + limit)
            answer = maxOf(answer, word.slice(i..<j))
        }

        return answer
    }
}