class Solution {
    fun maxUniqueSplit(s: String): Int {
        val substrings = mutableSetOf<String>()

        fun backtracking(index: Int): Int {
            if (index == s.length) {
                return 0
            }

            var count = 0
            for (i in index..s.lastIndex) {
                val substring = s.slice(index..i)
                if (substring !in substrings) {
                    substrings += substring
                    count = count.coerceAtLeast(backtracking(i + 1) + 1)
                    substrings -= substring
                }
            }

            return count
        }

        return backtracking(0)
    }
}