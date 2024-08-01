class Solution {
    fun countSeniors(details: Array<String>): Int {
        return details.count { it[11].digitToInt() * 10 + it[12].digitToInt() > 60 }
    }
}