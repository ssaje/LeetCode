class Solution {
    fun longestBalanced(s: String): Int {
        val n = s.length

        var answer = 1

        var count = 1
        var previous = 'd'
        for (ch in s) {
            if (ch != previous) {
                previous = ch
                count = 1
            } else {
                count++
                answer = maxOf(answer, count)
            }
        }

        fun two(target1: Char, target2: Char, excluded: Char) {
            var i = 0
            while (i < n) {
                if (s[i] == excluded) {
                    i++
                    continue
                }

                var j = i
                var diff = 0
                val firsts = mutableMapOf<Int, Int>(0 to j - 1)
                while (j < n) {
                    when (s[j]) {
                        target1 -> diff++
                        target2 -> diff--
                        else -> break
                    }

                    val previous = firsts.putIfAbsent(diff, j)
                    if (previous != null) {
                        answer = maxOf(answer, j - previous)
                    }

                    j++
                }

                i = j + 1
            }
        }

        two('a', 'b', 'c')
        two('b', 'c', 'a')
        two('c', 'a', 'b')

        var a = 0
        var b = 0
        var c = 0
        val firsts = mutableMapOf<Pair<Int, Int>, Int>((0 to 0) to -1)
        for (i in 0..<n) {
            when (s[i]) {
                'a' -> a++
                'b' -> b++
                else -> c++
            }

            val d = a - b to a - c
            val previous = firsts.putIfAbsent(d, i) ?: continue
            answer = maxOf(answer, i - previous)
        }

        return answer
    }
}