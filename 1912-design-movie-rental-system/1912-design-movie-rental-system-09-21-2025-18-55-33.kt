class MovieRentingSystem(n: Int, entries: Array<IntArray>) {
    private val rented = TreeSet<List<Int>> { a, b ->
        if (a[2] != b[2]) a[2].compareTo(b[2])
        else if (a[0] != b[0]) a[0].compareTo(b[0])
        else a[1].compareTo(b[1])
    }

    // movie, (price, shop)
    private val unrented = mutableMapOf<Int, TreeSet<List<Int>>>()

    private val shopMovieToPrice = mutableMapOf<List<Int>, Int>()

    init {
        entries.forEach { entry ->
            unrented
                .computeIfAbsent(entry[1]) {
                    TreeSet<List<Int>> { a, b ->
                        if (a[0] != b[0]) a[0].compareTo(b[0])
                        else a[1].compareTo(b[1])
                    }
                }
                .add(listOf(entry[2], entry[0]))

            shopMovieToPrice[listOf(entry[0], entry[1])] = entry[2]
        }
    }

    fun search(movie: Int): List<Int> {
        val pricesAndShops = unrented[movie] ?: return emptyList()

        return pricesAndShops.take(5).map { it[1] }
    }

    fun rent(shop: Int, movie: Int) {
        val price = shopMovieToPrice[listOf(shop, movie)]!!
        rented.add(listOf(shop, movie, price))
        unrented[movie]!!.remove(listOf(price, shop))
    }

    fun drop(shop: Int, movie: Int) {
        val price = shopMovieToPrice[listOf(shop, movie)]!!
        rented.remove(listOf(shop, movie, price))
        unrented[movie]!!.add(listOf(price, shop))
    }

    fun report(): List<List<Int>> {
        return rented.take(5).map { it.take(2) }
    }

}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * var obj = MovieRentingSystem(n, entries)
 * var param_1 = obj.search(movie)
 * obj.rent(shop,movie)
 * obj.drop(shop,movie)
 * var param_4 = obj.report()
 */