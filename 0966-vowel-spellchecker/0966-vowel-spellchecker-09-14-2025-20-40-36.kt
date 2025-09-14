class Solution {
    fun spellchecker(wordlist: Array<String>, queries: Array<String>): Array<String> {
        val words = wordlist.toSet()
        
        val case1 = mutableMapOf<String, String>()
        for (word in wordlist) {
            val normalized = word.lowercase()
            if (normalized !in case1) {
                case1[normalized] = word
            }
        }

        val case2 = mutableMapOf<String, String>()
        for (word in wordlist) {
            val normalized = word.lowercase().replace(Regex("[aeiou]"), "*")
            if (normalized !in case2) {
                case2[normalized] = word
            }
        }

        return queries.map { query ->
            if (query in words) {
                return@map query
            }
            
            var normalized = query.lowercase()
            if (normalized in case1) {
                return@map case1[normalized]!!
            }

            case2[normalized.replace(Regex("[aeiou]"), "*")] ?: ""
        }.toTypedArray()
    }
}