class Solution {
    fun validateCoupons(code: Array<String>, businessLine: Array<String>, isActive: BooleanArray): List<String> {
        return code.zip(businessLine).filterIndexed { i, (c, bl) -> 
            isActive[i] &&
            bl in setOf("electronics", "grocery", "pharmacy", "restaurant") &&
            c.isNotEmpty() &&
            c.all { ch -> ch in 'a'..'z' || ch in 'A'..'Z' || ch in '0'..'9' || ch == '_' }
        }.sortedWith(
            compareBy<Pair<String, String>> { it.second }
                .thenBy { it.first }
        ).map { it.first }
    }
}