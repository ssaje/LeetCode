class MyCircularDeque(val k: Int) {
    private val circularDeque = IntArray(k)
    var s = 1
    var e = 0
    var size = 0

    fun insertFront(value: Int): Boolean {
        if (isFull()) {
            return false
        }

        s = (s - 1 + k) % k
        circularDeque[s] = value
        size++

        return true
    }

    fun insertLast(value: Int): Boolean {
        if (isFull()) {
            return false
        }

        e = (e + 1) % k
        circularDeque[e] = value
        size++

        return true
    }

    fun deleteFront(): Boolean {
        if (isEmpty()) {
            return false
        }

        s = (s + 1) % k
        size--

        return true
    }

    fun deleteLast(): Boolean {
        if (isEmpty()) {
            return false
        }

        e = (e - 1 + k) % k
        size--

        return true
    }

    fun getFront(): Int {
        if (isEmpty()) {
            return -1
        }

        return circularDeque[s]
    }

    fun getRear(): Int {
        if (isEmpty()) {
            return -1
        }

        return circularDeque[e]
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun isFull(): Boolean {
        return size == k
    }

}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */