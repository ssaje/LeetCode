class ProductOfNumbers() {
    private val products = mutableListOf<Int>(1)
    var lastZeroIndex = 0

    fun add(num: Int) {
        if (num == 0) {
            products += 1
            lastZeroIndex = products.lastIndex
        } else {
            products += products.last() * num
        }
    }

    fun getProduct(k: Int): Int {
        if (lastZeroIndex + k > products.lastIndex) {
            return 0
        }

        return products.last() / products[products.lastIndex - k]
    }

}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * var obj = ProductOfNumbers()
 * obj.add(num)
 * var param_2 = obj.getProduct(k)
 */