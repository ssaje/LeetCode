class AllOne() {
    private val nodesByKey = mutableMapOf<String, Node>()
    private val linkedList = LinkedList()

    fun inc(key: String) {
        val node = nodesByKey[key]
        if (node == null) {
            val freq1Node = linkedList.getOrPutFreq1Node()
            nodesByKey[key] = freq1Node
            linkedList.addKeyToNode(key, freq1Node)
            return
        }
        
        val nextFreqNode = linkedList.getOrPutNextFreqNode(node)
        nodesByKey[key] = nextFreqNode
        linkedList.addKeyToNode(key, nextFreqNode)
        linkedList.removeKeyFromNode(key, node)
    }

    fun dec(key: String) {
        val node = nodesByKey[key]
        if (node == null) {
            return
        }

        if (node.freq == 1) {
            nodesByKey.remove(key)
            linkedList.removeKeyFromNode(key, node)
            return
        }
        
        val prevFreqNode = linkedList.getOrPutPrevFreqNode(node)
        nodesByKey[key] = prevFreqNode
        linkedList.addKeyToNode(key, prevFreqNode)
        linkedList.removeKeyFromNode(key, node)
    }

    fun getMaxKey(): String {
        return linkedList.getArbitrayKeyFromLastNode()
    }

    fun getMinKey(): String {
        return linkedList.getArbitrayKeyFromFirstNode()
    }

    private data class Node(val freq: Int) {
        var prev: Node? = null
        var next: Node? = null
        val keys: MutableSet<String> = mutableSetOf()
    }

    private class LinkedList {
        val head: Node
        val tail: Node

        init {
            head = Node(0)
            tail = Node(50_000 + 1)
            
            head.next = tail
            tail.prev = head
        }

        fun getArbitrayKeyFromFirstNode(): String {
            return head.next!!.keys.firstOrNull() ?: ""
        }

        fun getArbitrayKeyFromLastNode(): String {
            return tail.prev!!.keys.firstOrNull() ?: ""
        }

        fun getOrPutFreq1Node(): Node {
            return getOrPutNextFreqNode(head)
        }

        fun getOrPutNextFreqNode(node: Node): Node {
            val next = node.next
            if (next?.freq == node.freq + 1) {
                return next
            }

            val nextFreqNode = Node(node.freq + 1).apply {
                this.prev = node
                this.next = next
            }
            
            node.next = nextFreqNode
            next?.prev = nextFreqNode

            return nextFreqNode
        }

        fun getOrPutPrevFreqNode(node: Node): Node {
            val prev = node.prev
            if (prev?.freq == node.freq - 1) {
                return prev
            }

            val prevFreqNode = Node(node.freq - 1).apply {
                this.prev = prev
                this.next = node
            }
            
            node.prev = prevFreqNode
            prev?.next = prevFreqNode

            return prevFreqNode
        }

        fun addKeyToNode(key: String, node: Node) {
            node.keys += key
        }

        fun removeKeyFromNode(key: String, node: Node) {
            node.keys -= key
            if (node.keys.isEmpty()) {
                node.prev?.next = node.next.also {
                    node.next?.prev = node.prev
                }
            }
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * var obj = AllOne()
 * obj.inc(key)
 * obj.dec(key)
 * var param_3 = obj.getMaxKey()
 * var param_4 = obj.getMinKey()
 */