class Solution {
    fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
        val m = box.size
        val n = box[0].size
        val answer = Array(n) { CharArray(m) }
        for (i in 0..<m) {
            for (j in 0..<n) {
                answer[j][m - i - 1] = box[i][j]
            }
        }

        for (j in 0..<m) {
            var i = n - 1
            var k = n - 2
            while (i > 0) {
                if (answer[i][j] != '.') {
                    i--
                    continue
                }

                if (k >= i) {
                    k = i - 1
                }

                while (k >= 0) {
                    if (answer[k][j] != '.') {
                        break
                    }

                    k--
                }

                if (k < 0) {
                    break
                } else if (answer[k][j] == '*') {
                    i = k - 1
                    k = k - 2
                } else {
                    answer[i][j] = '#'
                    answer[k][j] = '.'
                    i--
                    k--
                }
            }
        }

        return answer
    }
}