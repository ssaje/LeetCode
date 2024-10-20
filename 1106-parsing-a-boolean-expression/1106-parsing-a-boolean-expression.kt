class Solution {
    fun parseBoolExpr(expression: String): Boolean {
        return parseExpr(expression, 0).first
    }

    private fun parseExpr(expression: String, index: Int): Pair<Boolean, Int> {
        val ch = expression[index]
        if (ch == 't') {
            return true to index
        } else if (ch == 'f') {
            return false to index
        } else if (ch == '!') {
            val parsed = parseExpr(expression, index + 2)
            return !parsed.first to (parsed.second + 1)
        }

        var i = index + 2
        val exprs = mutableListOf<Boolean>()
        while (expression[i] != ')') {
            val parsed = parseExpr(expression, i)
            exprs += parsed.first
            i = parsed.second + 1
            
            if (expression[i] == ',') {
                i++
            }
        }

        if (ch == '&') {
            return exprs.all { it == true } to i
        }

        if (ch == '|') {
            return exprs.any { it == true } to i
        }

        return false to -1
    }
}