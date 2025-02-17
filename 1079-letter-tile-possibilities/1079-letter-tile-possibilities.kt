class Solution {
    fun numTilePossibilities(tiles: String): Int {
        val sequences = mutableSetOf<String>()
        
        fun dfs(s: StringBuilder, str: String, index: Int) {
            val current = s.toString()
            if (current !in sequences) {
                sequences += current
            }

            if (str.length == index) {
                return
            }

            dfs(s, str, index + 1)

            s.append(str[index])
            dfs(s, str, index + 1)
            s.deleteAt(s.length - 1)
        }

        fun permutations(str: String): Set<String> = buildSet {
            if (str.length == 0) {
                return setOf("")
            }

            for (i in str.indices) {
                permutations(str.slice(0..<i) + str.slice(i+1..<str.length)).forEach {
                    add(str[i] + it)
                }
            }
        }

        permutations(tiles).forEach {
            dfs(StringBuilder(), it, 0)
        }

        return sequences.size - 1
    }
}