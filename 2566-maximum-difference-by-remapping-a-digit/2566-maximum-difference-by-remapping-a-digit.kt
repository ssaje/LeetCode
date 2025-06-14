class Solution {
    fun minMaxDifference(num: Int): Int {
        val str = num.toString()
        val max = str
            .indexOfFirst { it != '9' }
            .let { str[it] }
            .let { str.replace(it, '9') }
            .toInt()

        val min = str
            .indexOfFirst { it != '0' }
            .let { str[it] }
            .let { str.replace(it, '0') }
            .toInt()

        return max - min
    }
}