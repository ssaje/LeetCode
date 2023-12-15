class Solution {
    fun destCity(paths: List<List<String>>): String {
        val edges = paths.associate { it[0] to it[1] }
        var u = paths[0][0]
        do {
            val v = edges[u]
            if (v == null) {
                break
            }

            u = v
        } while (v != null)

        return u
    }
}