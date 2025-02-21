/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class FindElements(root: TreeNode?) {
    val targets = mutableSetOf<Int>()

    init {
        root?.let { dfs(it, 0) }
    }

    private fun dfs(node: TreeNode, value: Int) {
        targets += value
        node.left?.let { dfs(it, value * 2 + 1) }
        node.right?.let { dfs(it, value * 2 + 2) }
    }

    fun find(target: Int): Boolean {
        return target in targets
    }

}

/**
 * Your FindElements object will be instantiated and called as such:
 * var obj = FindElements(root)
 * var param_1 = obj.find(target)
 */