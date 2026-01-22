class Solution {
    fun minimumPairRemoval(nums: IntArray): Int {
        var list = nums.toMutableList()
        fun isNonDecreasing(): Boolean {
            for (i in 1..<list.size) {
                if (list[i - 1] > list[i]) return false
            }

            return true
        }

        var answer = 0
        while (!isNonDecreasing()) {
            answer++

            var min = Int.MAX_VALUE
            var idx = 0
            for (i in 1..<list.size) {
                val sum = list[i - 1] + list[i]
                if (min > sum) {
                    min = sum
                    idx = i - 1
                }
            }

            list = buildList {
                for (i in 0..<idx) {
                    add(list[i])
                }

                add(list[idx] + list[idx + 1])
                
                for (i in idx+2..<list.size) {
                    add(list[i])
                }
            }.toMutableList()
        }

        return answer
    }
}