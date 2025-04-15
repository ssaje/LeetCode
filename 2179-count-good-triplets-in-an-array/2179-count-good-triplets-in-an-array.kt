class Solution {
    fun goodTriplets(nums1: IntArray, nums2: IntArray): Long {
        // i < j < k && pos2[nums1[i]] < pos2[nums1[j]] < pos2[nums1[k]]
        // 0 <= nums1[x] < n
        val n = nums1.size
        
        val pos2 = IntArray(n)
        for (i in nums2.indices) {
            pos2[nums2[i]] = i
        }

        val v2ToPos1 = IntArray(n)
        for (i in nums1.indices) {
            v2ToPos1[pos2[nums1[i]]] = i
        }

        val fenwickTree = FenwickTree(n)
        var answer = 0L
        for (v2 in 0..<n) {
            val pos1 = v2ToPos1[v2]
            val left = fenwickTree.query(pos1)
            val right = (n - v2 - 1) - (pos1 - left)

            answer += left.toLong() * right
            fenwickTree.update(pos1, 1)
        }

        return answer
    }

    private class FenwickTree(private val size: Int) {
        private val tree = IntArray(size + 1)

        fun update(index: Int, delta: Int) {
            var pos = index + 1
            while (pos < tree.size) {
                tree[pos] += delta
                pos += pos and -pos
            }
        }

        fun query(index: Int): Int {
            var pos = index + 1
            var ret = 0
            while (pos > 0) {
                ret += tree[pos]
                pos = pos and (pos - 1)
            }

            return ret
        }
    }
}