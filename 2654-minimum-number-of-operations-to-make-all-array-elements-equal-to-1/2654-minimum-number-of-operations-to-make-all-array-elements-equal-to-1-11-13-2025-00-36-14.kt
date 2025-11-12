class Solution {
    fun minOperations(nums: IntArray): Int {
        val n = nums.size
        var count = 0
        var all = 0
        for (num in nums) {
            if (num == 1) count++
            
            all = gcd(num, all)
        }

        if (count > 0) return n - count
        if (all > 1) return -1

        var min = n
        for (i in 0..<n) {
            var current = 0
            for (j in i..<n) {
                current = gcd(nums[j], current)
                if (current == 1) {
                    min = minOf(min, j - i + 1)
                    break
                }
            }
        }

        return min - 1 + n - 1
    }

    private fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        else return gcd(b, a % b)
    }
}