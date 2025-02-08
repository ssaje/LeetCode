class NumberContainers() {
    private val numbersByIndex = mutableMapOf<Int, Int>()
    private val indexesByNumber = mutableMapOf<Int, PriorityQueue<Int>>()

    fun change(index: Int, number: Int) {
        numbersByIndex[index] = number

        if (number !in indexesByNumber) {
            indexesByNumber[number] = PriorityQueue()
        }

        indexesByNumber[number]!!.offer(index)
    }

    fun find(number: Int): Int {
        val indexes = indexesByNumber[number] ?: return -1
        while(indexes.isNotEmpty()) {
            val index = indexes.peek()
            if (numbersByIndex[index] == number) {
                return index
            }

            indexes.poll()
        }

        return -1
    }

}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * var obj = NumberContainers()
 * obj.change(index,number)
 * var param_2 = obj.find(number)
 */