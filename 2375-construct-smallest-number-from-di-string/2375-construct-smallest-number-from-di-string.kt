class Solution {
    fun smallestNumber(pattern: String): String {
        val m = pattern.length + 1
        val strings = mutableListOf<String>()
        val used = BooleanArray(10)

        fun dfs(sb: StringBuilder, index: Int) {
            if (index == m) {
                strings += sb.toString()
                return
            }

            for (i in 1..m) {
                if (used[i]) {
                    continue
                }

                used[i] = true
                sb.append(i.toString())
                dfs(sb, index + 1)
                sb.deleteAt(sb.length - 1)
                used[i] = false
            }
        }

        dfs(StringBuilder(), 0)

        fun isSolution(string: String): Boolean {
            for (i in pattern.indices) {
                if (pattern[i] == 'I') {
                    if (string[i].digitToInt() >= string[i + 1].digitToInt()) {
                        return false
                    }
                } else {
                    if (string[i].digitToInt() <= string[i + 1].digitToInt()) {
                        return false
                    }
                }
            }

            return true
        }

        for (string in strings) {
            if (isSolution(string)) {
                return string
            }
        }

        return ""
    }
}