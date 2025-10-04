class Solution {
    fun maxArea(height: IntArray): Int {
        var answer = 0
        var l = 0
        var r = height.size - 1
        while (l < r) {
            answer = maxOf(answer, (r - l) * minOf(height[l], height[r]))
            if (height[l] < height[r]) l++
            else r--
        }

        return answer
    }
}