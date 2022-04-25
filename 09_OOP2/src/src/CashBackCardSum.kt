import kotlin.math.roundToInt

class CashBackCardSum(
    balance: Double,
    creditLimit: Int
) : CreditCard(balance, creditLimit) {
    init {
        this.balance = (balance * 100).roundToInt() / 100.0
    }

    private val cashBack: Double = 5.0
    private val controlSum: Double = 5000.0

    override fun pay(paySum: Double) {

        val paySumRound: Double = (paySum * 100).roundToInt() / 100.0
        super.pay(paySumRound)

        if (paySumRound <= balance + creditBalance) {
            if (paySumRound >= controlSum) {
                append((paySumRound * cashBack).roundToInt() / 100.0)

                println(
                    "Кэшбек от покупки составил: " +
                            "${(paySumRound * cashBack).roundToInt() / 100.0}"
                )
            }
        }
    }

    override fun getAvailable() {
        super.getAvailable()
        println("\tПроцент кэшбека: $cashBack% при сумме покупки от 5000")
    }
}