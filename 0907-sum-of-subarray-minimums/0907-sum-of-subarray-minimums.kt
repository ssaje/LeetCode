class Solution {
    fun sumSubarrayMins(arr: IntArray): Int {
        val stack = Stack<Int>()
        stack.push(0)

        val a = IntArray(arr.size + 1) { arr.getOrElse(it - 1) { 0 } }
        val d = IntArray(arr.size + 1)

        var answer = 0
        for (i in 1..a.lastIndex) {
            while (a[stack.peek()] > a[i]) {
                stack.pop()
            }

            val prev = stack.peek()
            stack.push(i)

            d[i] = (d[prev] + (i - prev) * a[i]) % 1000000007
            answer = (answer + d[i]) % 1000000007
        }

        return answer
    }
}