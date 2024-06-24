class Solution {
    fun minKBitFlips(nums: IntArray, k: Int): Int {
        var answer = 0
        var acc = 0
        val diffs = IntArray(nums.size)
        for ((index, num) in nums.withIndex()) {
            if (num xor acc == 0) {
                if (index + k > nums.size) {
                    return -1
                }
                
                acc++
                answer++
                diffs[index + k - 1]++
            }

            acc = (acc + diffs[index]) % 2
        }

        return answer
    }
}