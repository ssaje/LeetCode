class Solution {
    fun countInterestingSubarrays(nums: List<Int>, modulo: Int, k: Int): Long {
        // counts[l..r] = counts[r] - counts[l - 1] = k (mod modulo)
        // counts[r] = counts[l - 1] + k (mod modulo)
        val m = mutableMapOf<Int, Int>(k % modulo to 1)
        var answer = 0L
        var acc = 0
        for (r in nums.indices) {
            acc += if (nums[r] % modulo == k) 1 else 0

            val count = m[acc % modulo] ?: 0
            answer += count
            
            val key = (acc + k) % modulo
            m[key] = (m[key] ?: 0) + 1
        }

        return answer
    }
}