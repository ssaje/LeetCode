class Solution {
    fun countAndSay(n: Int): String {
        var current = "1"
        repeat(n - 1) {
            current = buildString {
                var last = current[0]
                var count = 1
                for (i in 1..<current.length) {
                    if (last != current[i]) {
                        append("$count$last")
                        last = current[i]
                        count = 1
                    } else {
                        count++
                    }
                }

                append("$count$last")
            }
        }

        return current
    }
}