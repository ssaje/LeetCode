class Solution {
    fun makeLargestSpecial(s: String, l: Int = 0, r: Int = s.length): String {
        if (l == r) return ""

        val specials = buildList {
            var count = 0
            var i = 0
            while (i < s.length) {
                val special = buildString {
                    do {
                        if (s[i] == '1') count++
                        else count--

                        append(s[i])
                        i++
                    } while (count != 0)
                }

                val m = special.length
                val largest = "${special[0]}${makeLargestSpecial(special.slice(1..<m-1))}${special[m - 1]}"
                add(largest)
            }
        }.sortedDescending()

        return specials.joinToString("")
    }
}