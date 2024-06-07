class Solution {
    fun replaceWords(dictionary: List<String>, sentence: String): String {
        val trie = Trie()
        for (root in dictionary) {
            trie.add(root)
        }

        return sentence
            .split(" ")
            .map { trie.replaceDerivative(it) }
            .joinToString(" ")
    }

    private class Trie {
        private var isWord: Boolean = false
        private val children = mutableMapOf<Char, Trie>()

        fun add(str: String) {
            if (str.isEmpty()) {
                return
            }

            var node = this
            for (ch in str) {
                if (ch !in node.children) {
                    node.children += ch to Trie()
                }

                node = node.children[ch]!!
            }

            node.isWord = true
        }

        fun replaceDerivative(str: String): String = buildString {
            var node = this@Trie
            for (ch in str) {
                if (node.isWord) {
                    return@buildString
                }

                node = node.children[ch] ?: return@replaceDerivative str
                append(ch)
            }
        }
    }
}