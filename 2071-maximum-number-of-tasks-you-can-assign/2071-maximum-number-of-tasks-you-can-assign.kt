class Solution {
    fun maxTaskAssign(tasks: IntArray, workers: IntArray, pills: Int, strength: Int): Int {
        val ts = tasks.sorted()
        val ws = workers.sorted()

        fun isAssignable(n: Int): Boolean {
            var rest = pills
            val treeMap = TreeMap<Int, Int>()
            for (i in ws.size - n until ws.size) {
                val w = ws[i]
                treeMap[w] = (treeMap[w] ?: 0) + 1
            }

            for (i in n - 1 downTo 0) {
                val t = ts[i]
                val w = treeMap.lastKey()
                if (w >= t) {
                    treeMap[w] = treeMap[w]!! - 1
                    if (treeMap[w] == 0) {
                        treeMap.remove(w)
                    }
                } else {
                    if (rest == 0) {
                        return false
                    }

                    val min = treeMap.ceilingKey(t - strength) ?: return false
                    treeMap[min] = treeMap[min]!! - 1
                    if (treeMap[min] == 0) {
                        treeMap.remove(min)
                    }

                    rest--
                }
            }

            return true
        }

        var answer = 0
        var l = 1
        var r = min(ts.size, ws.size)
        while (l <= r) {
            val m = l + (r - l) / 2
            if (isAssignable(m)) {
                l = m + 1
                answer = m
            } else {
                r = m - 1
            }
        }

        return answer
    }
}