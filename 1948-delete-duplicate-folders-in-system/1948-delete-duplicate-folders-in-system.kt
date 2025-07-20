class Solution {
    fun deleteDuplicateFolder(paths: List<List<String>>): List<List<String>> {
        val trie = Trie()
        for (path in paths) {
            trie.add(path)
        }

        val counts = mutableMapOf<String, Int>()
        fun dfs(u: Trie) {
            if (u.children.isEmpty()) {
                u.key = ""
                return
            }

            val childrenKeys = u.children.mapTo(mutableListOf()) { (word, v) ->
                dfs(v)
                "$word(${v.key})"
            }

            childrenKeys.sort()

            val key = childrenKeys.joinToString("")
            u.key = key
            counts[key] = (counts[key] ?: 0) + 1
        }

        dfs(trie)

        var answer: MutableList<List<String>> = mutableListOf()
        fun delete(u: Trie, path: MutableList<String>) {
            val count = counts[u.key!!] ?: 0
            if (count > 1) return

            if (path.isNotEmpty()) {
                answer.add(buildList { addAll(path) })
            }

            u.children.forEach { (word, v) ->
                path.add(word)
                delete(v, path)
                path.removeLast()
            }
        }

        delete(trie, mutableListOf())

        return answer
    }

    private class Trie(
        val children: MutableMap<String, Trie> = mutableMapOf(),
        var key: String? = null,
    ) {
        fun add(words: Iterable<String>) {
            var root = this
            for (word in words) {
                root.children.putIfAbsent(word, Trie())
                root = root.children[word]!!
            }
        }
    }
}