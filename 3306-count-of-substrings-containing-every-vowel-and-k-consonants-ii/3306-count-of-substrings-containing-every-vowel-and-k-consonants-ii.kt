class Solution {
    fun countOfSubstrings(word: String, k: Int): Long {
        fun windowed(limit: Int): Long {
            val vs = mutableMapOf<Char, Int>()
            var s = 0
            var c = 0
            var acc = 0L
            for (e in word.indices) {
                val r = word[e]
                if (r in vowels) {
                    vs[r] = (vs[r] ?: 0) + 1
                } else {
                    ++c
                }

                while (vs.size == 5 && c >= limit) {
                    acc += word.length - e

                    val f = word[s]
                    if (f in vowels) {
                        vs[f] = (vs[f] ?: 0) - 1
                        if (vs[f] == 0) {
                            vs.remove(f)
                        }
                    } else {
                        --c
                    }

                    ++s
                }
            }

            return acc
        }

        return windowed(k) - windowed(k + 1)
    }

    companion object {
        private val vowels = setOf('a', 'e', 'i', 'o', 'u')
    }
}