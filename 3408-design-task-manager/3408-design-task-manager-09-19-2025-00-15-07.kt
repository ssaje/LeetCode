class TaskManager(tasks: List<List<Int>>) {
    private var timestamp = 0
    private val times = mutableMapOf<Int, Int>()
    private val users = mutableMapOf<Int, Int>()

    // priority, taskId, time
    private val pq = PriorityQueue<IntArray> { a, b ->
        if (a[0] != b[0]) b[0] - a[0]
        else b[1] - a[1]
    }

    init {
        for ((userId, taskId, priority) in tasks) {
            add(userId, taskId, priority)
        }
    }

    fun add(userId: Int, taskId: Int, priority: Int) {
        times[taskId] = ++timestamp
        users[taskId] = userId
        pq.offer(intArrayOf(priority, taskId, timestamp))
    }

    fun edit(taskId: Int, newPriority: Int) {
        times[taskId] = ++timestamp
        pq.offer(intArrayOf(newPriority, taskId, timestamp))
    }

    fun rmv(taskId: Int) {
        times[taskId] = 0
    }

    fun execTop(): Int {
        while (pq.isNotEmpty()) {
            val (priority, taskId, time) = pq.poll()
            if (times[taskId] != time) {
                continue
            }
            
            rmv(taskId)
            return users[taskId] ?: error("Impossible")
        }

        return -1
    }

}

/**
 * Your TaskManager object will be instantiated and called as such:
 * var obj = TaskManager(tasks)
 * obj.add(userId,taskId,priority)
 * obj.edit(taskId,newPriority)
 * obj.rmv(taskId)
 * var param_4 = obj.execTop()
 */