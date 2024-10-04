class Solution {
    fun dividePlayers(skill: IntArray): Long {
        val counts = LongArray(1001)
        var sum = 0
        skill.forEach {
            sum += it
            counts[it]++
        }

        if (sum % (skill.size / 2) != 0) {
            return -1
        }

        val target = sum / (skill.size / 2)
        var chemistry = 0L
        for (s in skill) {
            val t = target - s
            if (counts[t] == 0L) {
                return -1
            }

            counts[t]--
            chemistry += s * t
        }

        return chemistry / 2
    }
}