class Router(private val memoryLimit: Int) {
    private val queue = ArrayDeque<Packet>()
    private val packets = mutableSetOf<Packet>()
    private val timestamps = mutableMapOf<Int, ArrayDeque<Int>>()

    private data class Packet(
        val source: Int,
        val destination: Int,
        val timestamp: Int,
    )

    fun addPacket(source: Int, destination: Int, timestamp: Int): Boolean {
        val packet = Packet(source, destination, timestamp)
        if (packet in packets) return false

        if (destination !in timestamps) {
            timestamps[destination] = ArrayDeque()
        }

        timestamps[destination]!!.addLast(timestamp)
        packets.add(packet)

        queue.addLast(packet)
        if (queue.size > memoryLimit) {
            forwardPacket()
        }

        return true
    }

    fun forwardPacket(): IntArray {
        if (queue.size == 0) return intArrayOf()

        val packet = queue.removeFirst()
        timestamps[packet.destination]!!.removeFirst()
        packets.remove(packet)
        return intArrayOf(packet.source, packet.destination, packet.timestamp)
    }

    fun getCount(destination: Int, startTime: Int, endTime: Int): Int {
        val queue = timestamps[destination] ?: return 0
        return upperBound(queue, endTime) - lowerBound(queue, startTime)
    }

    private fun lowerBound(timestamps: ArrayDeque<Int>, target: Int): Int {
        var l = 0
        var r = timestamps.size
        while (l < r) {
            val m = l + (r - l) / 2
            if (timestamps[m] < target) l = m + 1
            else r = m
        }

        return l
    }

    private fun upperBound(timestamps: ArrayDeque<Int>, target: Int): Int {
        var l = 0
        var r = timestamps.size
        while (l < r) {
            val m = l + (r - l) / 2
            if (timestamps[m] <= target) l = m + 1
            else r = m
        }

        return l
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * var obj = Router(memoryLimit)
 * var param_1 = obj.addPacket(source,destination,timestamp)
 * var param_2 = obj.forwardPacket()
 * var param_3 = obj.getCount(destination,startTime,endTime)
 */