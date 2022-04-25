import kotlin.math.roundToInt

open class DebitCard(balance: Double) : BankCard(balance) {

    init {
        this.balance = (balance * 100).roundToInt() / 100.0
    }

    override fun append(appendSum: Double) {
        balance += (appendSum * 100).roundToInt() / 100.0
    }

    override fun pay(paySum: Double) {

        val paySumRound: Double = (paySum * 100).roundToInt() / 100.0

        if (paySumRound > balance)
            println("Недостаточно средств на балансе")
        else balance -= paySumRound
    }

    override fun getBalance() {
        println("Текущий баланс: ${(balance * 100).roundToInt() / 100}")
    }

    override fun getAvailable() {
        getBalance()
    }
}