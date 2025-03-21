class Solution {
    fun findAllRecipes(recipes: Array<String>, ingredients: List<List<String>>, supplies: Array<String>): List<String> {
        val cache = mutableMapOf<String, Boolean>()
        val recipeSet = recipes.toSet()
        val indexesByRecipe = recipes.withIndex().associate { it.value to it.index }
        val supplySet = supplies.toSet()

        fun isPossible(recipe: String): Boolean {
            val cached = cache[recipe]
            if (cached != null) {
                return cached
            }

            cache[recipe] = false

            val ingredient = ingredients[indexesByRecipe[recipe]!!]
            for (element in ingredient) {
                val isSufficient = if (element in recipeSet) {
                    isPossible(element)
                } else {
                    element in supplySet
                }

                if (!isSufficient) {
                    cache[recipe] = false
                    return false
                }
            }

            cache[recipe] = true
            return true
        }

        return recipes.filter { isPossible(it) }
    }
}