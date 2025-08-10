class Solution {
    fun reorderedPowerOf2(n: Int): Boolean {
        val nString = n.toString().toCharArray().sorted().joinToString("")
        var power = 1

        while (true) {
            val powerString = power.toString()
            if (powerString.length > nString.length) break
            
            if (powerString.length == nString.length && powerString.toCharArray().sorted().joinToString("") == nString) {
                return true
            }

            power *= 2
        }

        return false
    }
}