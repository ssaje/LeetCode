class Solution {
    fun subarrayBitwiseORs(arr: IntArray): Int {
        val answer = mutableSetOf<Int>()
        val rs = IntArray(30) { -1 }
        for (i in arr.indices) {
            var num = arr[i]
            answer += num
            
            val indexes = mutableListOf<Int>()
            for (index in 0..<30) {
                if (num and (1 shl index) > 0) {
                    rs[index] = i
                } else if (rs[index] != -1) {
                    indexes += rs[index]
                }
            }

            indexes.sortByDescending { it }
            for (index in indexes) {
                num = num or arr[index]
                answer += num
            }
        }

        return answer.size
    }
}