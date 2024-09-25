class Solution {
    fun sumPrefixScores(words: Array<String>): IntArray {
        val trie = Trie()
        for (word in words) {
            trie.insert(word)
        }

        return words.map { trie.getScore(it) }.toIntArray()
    }

    private data class TrieNode(
        val children: MutableMap<Char, TrieNode> = mutableMapOf(),
        var acc: Int = 0
    )

    private class Trie {
        private val root = TrieNode()

        fun insert(word: String) {
            var node = root
            for (ch in word) {
                node = node.children.getOrPut(ch) { TrieNode() }
                node.acc++
            }
        }

        fun getScore(word: String): Int {
            var score = 0
            var node = root
            for (ch in word) {
                node = node.children.getOrPut(ch) { TrieNode() }
                score += node.acc
            }

            return score
        }
    }
}