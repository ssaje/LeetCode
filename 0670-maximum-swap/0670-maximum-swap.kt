class Solution {
    fun maximumSwap(num: Int): Int {
        val chars = num.toString().toCharArray()
        val max = chars.max()
        for (i in chars.indices) {    
            if (chars[i] == max) {
                continue
            }

            var index = i
            for (j in i+1..chars.lastIndex) {
                if (chars[index] < chars[j] || (index != i && chars[index] == chars[j])) {
                    index = j
                }
            }

            if (index != i) {
                chars[i] = chars[index].also { chars[index] = chars[i] }
                return String(chars).toInt()
            }
        }

        return num
    }
}