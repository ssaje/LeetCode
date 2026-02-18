class Solution {
    fun readBinaryWatch(turnedOn: Int): List<String> {
        return buildList {
            for (h in 0..<12) {
                for (m in 0..<60) {
                    if (h.countOneBits() + m.countOneBits() == turnedOn) {
                        add("$h:${m.toString().padStart(2, '0')}")               
                    }
                }
            }
        }
    }
}