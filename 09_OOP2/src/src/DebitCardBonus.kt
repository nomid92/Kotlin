import kotlin.math.roundToInt

class DebitCardBonus(balance: Double) : DebitCard(balance) {
    private val bonus: Double = 3.0
    private var bonusBalance: Int = 0

    init {
        this.balance = (balance * 100).roundToInt() / 100.0
    }

    override fun pay(paySum: Double) {

        val paySumRound: Double = (paySum * 100).roundToInt() / 100.0
        if (paySumRound <= balance) {
            super.pay(paySumRound)
            bonusBalance += (paySumRound * bonus).roundToInt() / 100
            println(
                "Кэшбек от покупки составляет: " +
                        "${(paySumRound * bonus).roundToInt() / 100}"
            )
        }
    }

    fun payBalance(paySum: Double) {
        val paySumRound: Double = (paySum * 100).roundToInt() / 100.0

        if (paySumRound > bonusBalance)
            println("Недостаточно бонусных баллов")
        else bonusBalance = (bonusBalance.toDouble() - paySumRound).toInt()
    }

    override fun getAvailable() {
        super.getAvailable()
        println("\tПроцент начисления бонусных баллов от покупки: $bonus%" +
                "\n\tКоличество накопленных бонусов: $bonusBalance")
    }
}