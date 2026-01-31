class Solution {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        return letters.filter { target < it }.minOrNull() ?: letters[0]
    }
}