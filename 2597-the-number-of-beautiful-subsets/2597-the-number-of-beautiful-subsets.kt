class Solution {
    fun beautifulSubsets(nums: IntArray, k: Int): Int {
        var answer = 0
        val counts = IntArray(3005)
        var count = 0
        
        fun solve(index: Int) {
            if (nums.size == index) {
                if (count != 0) {
                    answer++
                }

                return
            }

            val num = nums[index]
            if (counts[num - k + 1000] == 0 && counts[num + k + 1000] == 0) {
                count++
                counts[num + 1000]++
                solve(index + 1)
                counts[num + 1000]--
                count--
            }

            solve(index + 1)
        }

        solve(0)

        return answer
    }
}