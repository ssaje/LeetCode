class Solution {
    fun longestBalanced(nums: IntArray): Int {
        val nexts = mutableMapOf<Int, ArrayDeque<Int>>()
        nexts.getOrPut(nums[0]) { ArrayDeque() }.addLast(0)
        
        val n = nums.size
        val pSums = IntArray(n)
        pSums[0] = nums[0].sgn

        for (i in 1..<n) {
            pSums[i] = pSums[i - 1]
            val q = nexts.getOrPut(nums[i]) { ArrayDeque() }
            if (q.isEmpty()) pSums[i] += nums[i].sgn
            q.addLast(i)
        }

        val m = n * 4 + 5
        val maxes = IntArray(m)
        val mins = IntArray(m)
        val lazy = IntArray(m)

        fun pull(node: Int) {
            val l = node * 2
            val r = l + 1
            maxes[node] = maxOf(maxes[l], maxes[r])
            mins[node] = minOf(mins[l], mins[r])
        }

        fun build(node: Int, l: Int, r: Int) {
            if (l == r) {
                maxes[node] = pSums[l]
                mins[node] = pSums[l]
                return
            }

            val m = l + (r - l) / 2
            build(node * 2, l, m)
            build(node * 2 + 1, m + 1, r)
            pull(node)
        }

        build(1, 0, n - 1)

        fun push(node: Int) {
            val d = lazy[node]
            if (d != 0) {
                val l = node * 2
                val r = l + 1
                
                lazy[node] = 0

                maxes[l] += d
                mins[l] += d
                lazy[l] += d

                maxes[r] += d
                mins[r] += d
                lazy[r] += d
            }
        }

        fun query(node: Int, l: Int, r: Int, ql: Int, qr: Int, qv: Int): Int {
            if (maxes[node] < qv || mins[node] > qv) return -1
            if (l == r) return l
            
            push(node)

            val m = l + (r - l) / 2
            if (m < qr) {
                val j = query(node * 2 + 1, m + 1, r, ql, qr, qv)
                if (j != -1) return j
            }

            if (ql <= m) return query(node * 2, l, m, ql, qr, qv)

            return -1
        }

        fun update(node: Int, l: Int, r: Int, ql: Int, qr: Int, d: Int) {
            if (ql <= l && r <= qr) {
                maxes[node] += d
                mins[node] += d
                lazy[node] += d
                return
            }

            push(node)
            val m = l + (r - l) / 2
            if (ql <= m) update(node * 2, l, m, ql, qr, d)
            if (m < qr) update(node * 2 + 1, m + 1, r, ql, qr, d)
            pull(node)
        }

        var answer = 0
        for (i in 0..<n) {
            val s = i + answer
            if (s < n) {
                val j = query(1, 0, n - 1, s, n - 1, 0)
                if (j != -1) answer = maxOf(answer, j - i + 1)
            }

            val q = nexts[nums[i]]!!
            q.removeFirst()

            val next = if (q.isEmpty()) n else q.first()
            update(1, 0, n - 1, i, next - 1, -nums[i].sgn)
        }

        return answer
    }

    private val Int.sgn: Int
        get() = if (this % 2 == 0) 1 else -1
}