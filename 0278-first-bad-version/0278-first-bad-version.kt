/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

class Solution: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        // [l, r)
        var l = 0
        var r = n
        while (l < r) {
            val m = l + (r - l) / 2
            if (isBadVersion(m + 1)) {
                r = m
            } else {
                l = m + 1
            }
        }

        return r + 1
	}
}