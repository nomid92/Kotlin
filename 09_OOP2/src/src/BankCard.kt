abstract class BankCard(
    var balance: Double
) {
    abstract fun append(appendSum: Double)
    abstract fun pay(paySum: Double)
    abstract fun getBalance()
    abstract fun getAvailable()
}