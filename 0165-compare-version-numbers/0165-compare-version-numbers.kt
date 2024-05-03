class Solution {
    fun compareVersion(version1: String, version2: String): Int {
        val v1 = version1.split(".").map { it.toInt() }
        val v2 = version2.split(".").map { it.toInt() }

        val max = v1.size.coerceAtLeast(v2.size)

        (0..<max).forEach {
            if (v1.getOrElse(it) { 0 } < v2.getOrElse(it) { 0 }) {
                return -1
            } else if (v1.getOrElse(it) { 0 } > v2.getOrElse(it) { 0 }) {
                return 1
            }
        }

        return 0
    }
}