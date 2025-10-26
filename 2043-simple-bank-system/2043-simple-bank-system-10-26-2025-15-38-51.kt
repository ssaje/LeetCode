class Bank(balance: LongArray) {
    private val n = balance.size
    private val balances = LongArray(n) { balance[it] }

    fun transfer(account1: Int, account2: Int, money: Long): Boolean {
        if (account1 > n || account2 > n) return false
        if (balances[account1 - 1] < money) return false

        balances[account1 - 1] -= money
        balances[account2 - 1] += money

        return true
    }

    fun deposit(account: Int, money: Long): Boolean {
        if (account > n) return false
        balances[account - 1] += money
        return true
    }

    fun withdraw(account: Int, money: Long): Boolean {
        if (account > n) return false
        if (balances[account - 1] < money) return false
        balances[account - 1] -= money
        return true
    }

}

/**
 * Your Bank object will be instantiated and called as such:
 * var obj = Bank(balance)
 * var param_1 = obj.transfer(account1,account2,money)
 * var param_2 = obj.deposit(account,money)
 * var param_3 = obj.withdraw(account,money)
 */