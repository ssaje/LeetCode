class Solution {
    fun dividePlayers(skill: IntArray): Long {
        val counts = LongArray(2001)
        var sum = 0
        skill.forEach {
            sum += it
            counts[it]++
        }

        if (sum % (skill.size / 2) != 0) {
            return -1
        }

        val target = sum / (skill.size / 2)
        val half = (target + 1) / 2
        if (target % 2 == 0 && counts[half] % 2 == 1L) {
            return -1
        }

        var chemistry = if (target % 2 == 0) {
            half * half * counts[half] / 2
        } else {
            0
        }

        for (i in 1..<half) {
            if (counts[i] != counts[target - i]) {
                return -1
            }

            chemistry += i * (target - i) * counts[i]
        }

        return chemistry
    }
}