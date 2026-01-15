class Solution {
    fun maximizeSquareHoleArea(n: Int, m: Int, hBars: IntArray, vBars: IntArray): Int {
        val hs = hBars.sorted()
        var hMax = 1
        var h = 1
        for (i in 1..<hBars.size) {
            if (hs[i - 1] + 1 == hs[i]) {
                h++
            } else {
                h = 1
            }

            hMax = maxOf(hMax, h)
        }

        val vs = vBars.sorted()
        var vMax = 1
        var v = 1
        for (i in 1..<vBars.size) {
            if (vs[i - 1] + 1 == vs[i]) {
                v++
            } else {
                v = 1
            }

            vMax = maxOf(vMax, v)
        }

        val side = minOf(hMax, vMax) + 1
        return side * side
    }
}