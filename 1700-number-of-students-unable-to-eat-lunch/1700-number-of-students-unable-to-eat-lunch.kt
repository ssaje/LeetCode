class Solution {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        val checked = BooleanArray(students.size)
        var i = 0
        for (sandwiche in sandwiches) {
            var size = 0
            while (size < students.size) {
                if (!checked[i] && students[i] == sandwiche) {
                    checked[i] = true
                    break
                }

                i = (i + 1) % students.size
                size++
            }

            if (size == students.size) {
                return checked.count { !it }
            }
        }

        return 0
    }
}