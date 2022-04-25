import kotlin.math.roundToInt

class CashBachCard(balance: Double, creditLimit: Int) : CreditCard(balance, creditLimit) {
    private val cashBack: Double = 1.5

    init {
        this.balance = (balance * 100).roundToInt() / 100.0
    }

    override fun pay(paySum: Double) {

        val paySumRound: Double = (paySum * 100).roundToInt() / 100.0
        super.pay(paySum)

        if (paySumRound <= balance + creditBalance) {
            append((paySumRound * cashBack).roundToInt() / 100.0)

            println(
                "Кэшбек от поккупки составляет: " +
                        (paySumRound * cashBack).roundToInt() / 100
            )
        }
    }

    override fun getAvailable() {
        super.getAvailable()
        println("\tПроцент кэшбека: $cashBack%")
    }
}