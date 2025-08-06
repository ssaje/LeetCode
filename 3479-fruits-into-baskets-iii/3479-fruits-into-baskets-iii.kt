class Solution {
    fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
        val n = baskets.size
        val m = sqrt(n.toDouble()).toInt()
        
        val blockSize = (n + m - 1) / m
        println("blockSize: $blockSize")
        val blocks = IntArray(blockSize)
        for (i in 0..<n) {
            blocks[i / m] = maxOf(blocks[i / m], baskets[i])
        }

        var answer = 0
        val used = BooleanArray(n)
        for (fruit in fruits) {
            var blockIndex = 0
            while (blockIndex < blockSize) {
                if (blocks[blockIndex] < fruit) {
                    blockIndex++
                    continue
                }

                blocks[blockIndex] = 0

                var isSelected = false
                for (j in 0..<m) {
                    val k = blockSize * blockIndex + j
                    if (k >= n) break
                    if (used[k]) continue

                    if (!isSelected && baskets[k] >= fruit) {
                        used[k] = true
                        isSelected = true
                    } else {
                        blocks[blockIndex] = maxOf(blocks[blockIndex], baskets[k])
                    }
                }

                break
            }

            if (blockIndex == blockSize) {
                answer++
            }
        }

        return answer
    }
}