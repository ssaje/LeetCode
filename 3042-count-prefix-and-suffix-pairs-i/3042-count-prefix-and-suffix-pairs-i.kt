class Solution {
    fun countPrefixSuffixPairs(words: Array<String>): Int {
        var answer = 0
        for (i in words.indices) {
            for (j in i+1..words.lastIndex) {
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                    answer++
                }
            }
        }

        return answer
    }
}