class Solution {
    fun minOperations(s: String): Int {
        var zero = 0
        var one = 0
        
        s.forEachIndexed { index, ch -> 
            when (index % 2) {
                0 -> {
                    if (ch == '0') {
                        one++
                    } else {
                        zero++
                    }
                }

                else -> {
                    if (ch == '0') {
                        zero++
                    } else {
                        one++
                    }
                }
            }
        }

        return zero.coerceAtMost(one)
    }
}