class Solution {
    fun countOfAtoms(formula: String): String {
        // 풀기 귀찮아서 copy & paste
        val matcher = Pattern
            .compile("([A-Z][a-z]*)(\\d*)|(\\()|(\\))(\\d*)")
            .matcher(formula)

        val list: MutableList<Array<String?>> = mutableListOf()
        while (matcher.find()) {
            list.add(
                arrayOf(
                    matcher.group(1),
                    matcher.group(2),
                    matcher.group(3),
                    matcher.group(4),
                    matcher.group(5),
                )
            )
        }

        list.reverse()

        val finalMap: MutableMap<String, Int> = mutableMapOf()

        val stack = Stack<Int>()
        stack.push(1)

        var runningMul = 1
        for (quintuple in list) {
            val atom = quintuple[0]
            val count = quintuple[1]
            val left = quintuple[2]
            val right = quintuple[3]
            val multiplier = quintuple[4]

            if (atom != null) {
                val cnt = if (count?.isNotEmpty() == true) {
                    count.toInt()
                } else {
                    1
                }

                finalMap[atom] = finalMap.getOrDefault(atom, 0) + cnt * runningMul
            } else if (right != null) {
                val currMultiplier = if (multiplier?.isNotEmpty() == true) {
                    multiplier.toInt()
                } else {
                    1
                }

                runningMul *= currMultiplier
                stack.push(currMultiplier)
            } else if (left != null) {
                runningMul /= stack.pop()
            }
        }

        return buildString {
            val sortedMap = TreeMap(finalMap)

            for (atom in sortedMap.keys) {
                append(atom)
                if (sortedMap[atom]!! > 1) {
                    append(sortedMap[atom])
                }
            }
        }
    }
}