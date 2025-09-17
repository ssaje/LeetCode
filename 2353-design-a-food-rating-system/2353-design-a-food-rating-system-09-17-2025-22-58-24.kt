class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {
    private val n = foods.size
    private val cuisineMapping = mutableMapOf<String, String>()
    private val ratingMapping = mutableMapOf<String, Int>()

    // cuisine -> (rating, food)
    private val sortedSetsByCuisine = mutableMapOf<String, TreeSet<Pair<Int, String>>>()

    init {
        for (i in foods.indices) {
            val food = foods[i]
            cuisineMapping[food] = cuisines[i]
            ratingMapping[food] = ratings[i]

            sortedSetsByCuisine
                .computeIfAbsent(cuisines[i]) {
                    TreeSet { a, b ->
                        if (a.first == b.first) a.second.compareTo(b.second)
                        else b.first.compareTo(a.first)
                    }
                }
                .add(ratings[i] to food)
        }
    }

    fun changeRating(food: String, newRating: Int) {
        val cuisine = cuisineMapping[food]
        val sortedSet = sortedSetsByCuisine[cuisine]!!

        sortedSet.remove(ratingMapping[food]!! to food)

        ratingMapping[food] = newRating
        sortedSet.add(newRating to food)
    }

    fun highestRated(cuisine: String): String {
        return sortedSetsByCuisine[cuisine]!!.first().second
    }

}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * var obj = FoodRatings(foods, cuisines, ratings)
 * obj.changeRating(food,newRating)
 * var param_2 = obj.highestRated(cuisine)
 */