class Solution {
    fun numberOfBeams(bank: Array<String>): Int {
        return bank
            .fold(0 to 0) { acc, row ->
                val sum = row.count { it == '1' }
                if (sum == 0) {
                    return@fold acc
                }

                (acc.first + acc.second * sum) to sum
            }
            .first
    }
}