import java.util.PriorityQueue

class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {
    private val cuisinesByFood: Map<String, String>
    private val timestampsByFood: MutableMap<String, Int>
    private val highestRatingsByCuisine: Map<String, PriorityQueue<Rating>>

    init {
        cuisinesByFood = foods
            .asSequence()
            .zip(cuisines.asSequence())
            .associate { it.first to it.second }

        timestampsByFood = foods
            .associateWith { 0 }
            .toMutableMap()

        highestRatingsByCuisine = cuisines
            .distinct()
            .map { it to PriorityQueue<Rating>(Collections.reverseOrder()) }
            .toMap(mutableMapOf())

        for ((index, food) in foods.withIndex()) {
            val cuisine = cuisines[index]
            val rating = ratings[index]
            highestRatingsByCuisine[cuisine]!!.add(Rating(food = food, rating = rating))
        }
    }

    fun changeRating(food: String, newRating: Int) {
        val cuisine = cuisinesByFood[food] ?: return
        val timestamp = timestampsByFood[food] ?: return
        val rating = Rating(food = food, rating = newRating, timestamp = timestamp + 1)
        val pq = highestRatingsByCuisine[cuisine] ?: return
        
        pq.add(rating)
        timestampsByFood[food] = timestamp + 1
    }

    fun highestRated(cuisine: String): String {
        val pq = highestRatingsByCuisine[cuisine] ?: throw IllegalArgumentException()
        while(true) {
            val top = pq.element()
            if (top.timestamp != timestampsByFood[top.food]) {
                pq.remove()
            } else {
                return top.food
            }
        }

        throw IllegalArgumentException()
    }

    private data class Rating(
        val food: String,
        val rating: Int,
        val timestamp: Int = 0,
    ): Comparable<Rating> {
        override fun compareTo(other: Rating): Int {
            return when {
                this.rating != other.rating -> this.rating - other.rating
                else -> other.food.compareTo(this.food)
            }
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * var obj = FoodRatings(foods, cuisines, ratings)
 * obj.changeRating(food,newRating)
 * var param_2 = obj.highestRated(cuisine)
 */