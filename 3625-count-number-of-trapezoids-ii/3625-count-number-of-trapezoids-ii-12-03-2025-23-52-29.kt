class Solution {
    fun countTrapezoids(points: Array<IntArray>): Int {
        val counts = mutableMapOf<Triple<Int, Int, Int>, Int>()
        val midToDirs = mutableMapOf<Pair<Int, Int>, MutableList<Pair<Int, Int>>>()
        
        val n = points.size
        for (i in 0..<n) {
            val (x1, y1) = points[i]
            for (j in i+1..<n) {
                val (x2, y2) = points[j]
                val dx = x1 - x2
                val dy = y1 - y2
                val g = gcd(dx.absoluteValue, dy.absoluteValue)

                var x = dx / g
                var y = dy / g
                if (x < 0 || (x == 0 && y < 0)) {
                    x = -x
                    y = -y
                }
                
                val cp = x * y1 - y * x1
                val key = Triple(x, y, cp)
                counts[key] = (counts[key] ?: 0) + 1

                val mid = (x1 + x2) to (y1 + y2)
                val dirs = midToDirs.getOrPut(mid) { mutableListOf() }
                dirs += x to y
            }
        }

        var trapezoids = 0
        val dirSums = mutableMapOf<Pair<Int, Int>, IntArray>()
        for ((key, count) in counts) {
            val (x, y) = key
            val dir = x to y
            val dirSum = dirSums.getOrPut(dir) { IntArray(2) }
            dirSum[0] += count
            dirSum[1] += count * count
        }

        for ((s, ss) in dirSums.values) {
            trapezoids += (s * s - ss) / 2
        }

        var parallelograms = 0
        for (dirs in midToDirs.values) {
            if (dirs.size < 2) continue

            val dirCounts = mutableMapOf<Pair<Int, Int>, Int>()
            for (dir in dirs) {
                dirCounts[dir] = (dirCounts[dir] ?: 0) + 1
            }

            var sum = 0
            for (dirCount in dirCounts.values) {
                parallelograms += sum * dirCount
                sum += dirCount
            }
        }

        return trapezoids - parallelograms
    }

    private fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        else return gcd(b, a % b)
    }
}