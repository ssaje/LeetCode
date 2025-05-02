class Solution {
    fun pushDominoes(dominoes: String): String {
        val n = dominoes.length
        val counts = IntArray(n)
        var count = 0
        for (i in dominoes.length - 1 downTo 0) {
            if (dominoes[i] == 'L') {
                count = n
            } else if (dominoes[i] == 'R') {
                count = 0
            } else if (count > 0) {
                count--
            }

            counts[i] = count
        }

        return buildString {
            count = 0
            for (i in dominoes.indices) {
                if (dominoes[i] == 'R') {
                    count = n
                } else if (dominoes[i] == 'L') {
                    count = 0
                }  else if (count > 0) {
                    count--
                }

                if (counts[i] > count) {
                    append('L')
                } else if (counts[i] == count) {
                    append('.')
                } else {
                    append('R')
                }
            }
        }
    }
}