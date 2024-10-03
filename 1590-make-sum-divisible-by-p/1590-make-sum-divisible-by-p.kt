class Solution {
    fun minSubarray(nums: IntArray, p: Int): Int {        
        // Si%p = Sj%p - S%p + p mod p
        val s = p - nums.fold(0) { acc, value -> (acc + value) % p }
        if (s == p) {
            return 0
        }

        val rems = mutableMapOf<Int, Int>()
        rems += 0 to -1

        var sum = 0
        var answer = nums.size
        for (j in nums.indices) {
            sum = (sum + nums[j]) % p
            
            val i = rems[(sum + s) % p]
            if (i != null) {
                answer = answer.coerceAtMost(j - i)
            }

            rems += sum to j
        }

        return if (answer == nums.size) {
            -1
        } else {
            answer
        }
    }
}