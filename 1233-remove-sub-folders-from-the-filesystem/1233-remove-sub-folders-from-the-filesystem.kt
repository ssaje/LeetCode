class Solution {
    fun removeSubfolders(folder: Array<String>): List<String> {
        val sorted = folder.sorted()

        return buildList {
            var i = 0

            this += sorted.first()

            for (j in 1..sorted.lastIndex) {
                if (sorted[j].startsWith(sorted[i]) && sorted[j][sorted[i].length] == '/') {
                    continue
                }

                i = j
                this += sorted[j]
            }
        }
    }
}