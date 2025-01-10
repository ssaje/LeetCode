class Solution {
    fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
        val freqs = words2.map { word ->
            word.groupingBy { it }.eachCount().toMap()
        }

        return words1.filter { word ->
            val freqs1 = word.groupingBy { it }.eachCount().toMap()
            
            freqs.all { freq ->
                freq.all { (key, value) ->
                    val freq1 = freqs1[key] ?: return@all false
                    freq1 >= value
                }
            }
        }
    }
}