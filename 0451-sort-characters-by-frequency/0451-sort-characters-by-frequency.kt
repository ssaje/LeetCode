class Solution {
    fun frequencySort(s: String): String {
        val frequenciesByCharacter = s
            .groupingBy { it }
            .eachCount()

        return s
            .toCharArray()
            .sortedWith(
                compareBy(
                    { -frequenciesByCharacter[it]!! },
                    { it },
                )
            )
            .joinToString("")
    }
}