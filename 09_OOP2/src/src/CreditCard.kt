import kotlin.math.roundToInt

open class CreditCard(
    balance: Double,
    private val creditLimit: Int
) : BankCard(balance) {

    init {
        this.balance = (balance * 100).roundToInt() / 100.0
    }

    internal var creditBalance: Double = creditLimit.toDouble()

    override fun append(appendSum: Double) {
        val appendSumRound: Double = (appendSum * 100).roundToInt() / 100.0
        if (creditBalance < creditLimit) {
            creditBalance += appendSumRound

            if (creditBalance > creditLimit) {
                balance = creditBalance - creditLimit.toDouble()
                creditBalance -= balance
            }
        } else
            balance += appendSumRound
    }

    override fun pay(paySum: Double) {
        val paySumRound: Double = (paySum * 100).roundToInt() / 100.0
        when {
            paySumRound > balance + creditBalance ->
                println("Недостаточно средств на балансе")

            balance > 0 -> {
                if (paySumRound < balance)
                    balance -= paySumRound
                else {
                    val remainderSum: Double = paySumRound - balance
                    balance = 0.0
                    creditBalance -= remainderSum
                }
            }
            else -> creditBalance -= paySumRound
        }
    }

    override fun getBalance() {
        println(
            "Текущий баланс: " +
                    "\tКредитных средств $creditBalance" +
                    "\tСобственных средств: $balance"
        )
    }

    override fun getAvailable() {
        println(
            "Кредитная карта с лимитом: $creditLimit" +
                    "\n\tДоступно кредитных средств: $creditBalance" +
                    "\n\tДоступно собственных средств: $balance"
        )
    }
}