class Solution {
    fun maximumEnergy(energy: IntArray, k: Int): Int {
        val sums = IntArray(k)
        var answer = -1000
        for (i in energy.size - 1 downTo 0) {
            sums[i % k] += energy[i]
            answer = maxOf(answer, sums[i % k])
        }

        return answer
    }
}