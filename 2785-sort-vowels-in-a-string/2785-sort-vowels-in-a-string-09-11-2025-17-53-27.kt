class Solution {
    fun sortVowels(s: String): String {
        val arr = s.toCharArray()
        val counts = IntArray(255)
        for (ch in arr) {
            counts[ch - 'A']++
        }

        var idx = 0
        for (i in arr.indices) {
            while (idx < 10 && counts[vowels[idx] - 'A'] == 0) {
                idx++
            }

            if (idx == 10) break

            if (arr[i] in vowels) {
                val vowel = vowels[idx]
                arr[i] = vowel
                --counts[vowel - 'A']
            }
        }

        return arr.joinToString("")
    }

    companion object {
        private val vowels = listOf('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u')
    }
}