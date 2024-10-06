class Solution {
    fun areSentencesSimilar(sentence1: String, sentence2: String): Boolean {
        val (shorter, longer) = if (sentence1.length < sentence2.length) {
            sentence1.split(" ") to sentence2.split(" ")
        } else {
            sentence2.split(" ") to sentence1.split(" ")
        }

        return isSimilar(shorter, longer) || isSimilar(shorter.reversed(), longer.reversed())
    }

    fun isSimilar(shorter: List<String>, longer: List<String>): Boolean {
        if (shorter[0] != longer[0]) {
            return false
        }

        if (shorter.size == 1) {
            return true
        }

        val s = shorter.drop(1)
        val l = longer.drop(1)
        
        return isSimilar(s, l) || isSimilar(s.reversed(), l.reversed())
    }
}