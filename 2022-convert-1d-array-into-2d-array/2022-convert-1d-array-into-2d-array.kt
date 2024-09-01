class Solution {
    fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {
        if (original.size != m * n) {
            return arrayOf()
        }

        return original.asIterable().chunked(n).map { it.toIntArray() }.toTypedArray()
    }
}