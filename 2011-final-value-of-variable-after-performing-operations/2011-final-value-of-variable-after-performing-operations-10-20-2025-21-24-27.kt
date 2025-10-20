class Solution {
    fun finalValueAfterOperations(operations: Array<String>): Int {
        var answer = 0
        for (operation in operations) {
            if (operation.startsWith('-') || operation.endsWith('-')) answer--
            else answer++
        }

        return answer
    }
}