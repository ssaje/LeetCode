class CustomStack(private val maxSize: Int) {
    var size = 0
    var diff = 0
    val stack = IntArray(maxSize)
    val incs = IntArray(maxSize)
    val decs = IntArray(maxSize)

    fun push(x: Int) {
        if (size == maxSize) {
            return
        }

        decs[size] -= diff
        diff = 0

        stack[size] = x
        size++
    }

    fun pop(): Int {
        if (size == 0) {
            return -1
        }

        size--
        diff += incs[size]
        incs[size] = 0

        val element = stack[size] + diff
        
        diff -= decs[size]
        decs[size] = 0

        return element
    }

    fun increment(k: Int, `val`: Int) {
        if (size == 0) {
            return
        }

        val limitedK = k.coerceAtMost(size) - 1
        decs[0] += `val`
        incs[limitedK] += `val`
    }

}

/**
 * Your CustomStack object will be instantiated and called as such:
 * var obj = CustomStack(maxSize)
 * obj.push(x)
 * var param_2 = obj.pop()
 * obj.increment(k,`val`)
 */