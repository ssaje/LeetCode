class Solution {
    fun countMentions(numberOfUsers: Int, events: List<List<String>>): IntArray {
        val onlineT = IntArray(numberOfUsers)
        val sorted = events.sortedWith(
            compareBy<List<String>> { it[1].toInt() }
                .thenBy { it[0] == "MESSAGE" }
        )
        val answer = IntArray(numberOfUsers)
        for ((type, t, str) in sorted) {
            val timestamp = t.toInt()
            if (type == "OFFLINE") {
                onlineT[str.toInt()] = timestamp.toInt() + 60
                continue
            }

            for (mention in str.split(" ")) {
                when (mention) {
                    "ALL" -> {
                        for (i in 0..<numberOfUsers) answer[i]++
                    }
                    
                    "HERE" -> {
                        for (i in 0..<numberOfUsers) {
                            if (onlineT[i] <= timestamp) {
                                answer[i]++
                            }
                        }
                    }

                    else -> {
                        val user = mention.drop(2).toInt()
                        answer[user]++
                    }
                }
            }
        }

        return answer
    }
}