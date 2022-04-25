import java.util.*
import kotlin.math.roundToInt

class DebitCardDeposit(balance: Double) : DebitCard(balance) {

    constructor(balance: Double, calendar: Calendar) : this(balance) {
        dateOpen = calendar
        nextCapitalisation = dateOpen
    }

    private val rate: Double = 7.0
    private var dateOpen: Calendar = Calendar.getInstance()
    var nextCapitalisation: Calendar = dateOpen
    private var minBalanceOfMonth = balance

    init {
        this.balance = (balance * 100).roundToInt() / 100.0
        nextCapitalisation.add(Calendar.MONTH, 1)
    }

    fun capitalisation() {
        val currentDate: Calendar = Calendar.getInstance()

        if (currentDate.get(Calendar.DATE) >= nextCapitalisation.get(Calendar.DATE)
            && currentDate.get(Calendar.MONTH) >= nextCapitalisation.get(Calendar.MONTH)
            && currentDate.get(Calendar.YEAR) >= nextCapitalisation.get(Calendar.YEAR)
        ) {
            val tepmCurrentDate: Calendar = nextCapitalisation
            tepmCurrentDate.add(Calendar.MONTH, -1)
            println(
                "Сумма накоплений за последний месяц: " +
                        (minBalanceOfMonth * rate * tepmCurrentDate.get(Calendar.DAY_OF_MONTH) /
                                tepmCurrentDate.get(Calendar.DAY_OF_YEAR)
                                ).roundToInt() / 100
            )
            balance +=
                (minBalanceOfMonth * rate * tepmCurrentDate.get(Calendar.DAY_OF_MONTH) /
                        tepmCurrentDate.get(Calendar.DAY_OF_YEAR)).roundToInt() / 100

            minBalanceOfMonth = balance
            nextCapitalisation.add(Calendar.MONTH, 1)
        }
    }

    override fun pay(paySum: Double) {
        if (paySum <= balance) {
            super.pay(paySum)
            if (minBalanceOfMonth > balance) minBalanceOfMonth = balance
        }
    }

    override fun getAvailable() {
        super.getAvailable()
        println("\tПроцентная ставка на остаток счета: $rate%" +
                "\n\tМинимальный баланс за месяц: ${(minBalanceOfMonth * 100).roundToInt() / 100.0}" +
                "\n\tСледующая дата начисления процентав: ${nextCapitalisation.time}")
    }
}