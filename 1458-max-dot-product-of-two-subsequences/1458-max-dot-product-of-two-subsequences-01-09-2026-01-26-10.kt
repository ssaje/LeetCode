class Solution {
    fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {
        val n = nums1.size
        val m = nums2.size
        var dp = Array(n) { IntArray(m) }
        
        dp[0][0] = nums1[0] * nums2[0]
        
        for (i in 1..<n) {
            dp[i][0] = maxOf(dp[i - 1][0], nums1[i] * nums2[0])
        }

        for (j in 1..<m) {
            dp[0][j] = maxOf(dp[0][j - 1], nums1[0] * nums2[j])
        }

        for (i in 1..<n) {
            for (j in 1..<m) {
                dp[i][j] = maxOf(dp[i][j - 1], dp[i - 1][j], nums1[i] * nums2[j] + dp[i - 1][j - 1])
            }
        }

        return dp[n - 1][m - 1]
    }
}