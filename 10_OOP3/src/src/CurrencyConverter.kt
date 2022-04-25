interface CurrencyConverter {
    val currencyCode: String

    fun convertToRub(count: Double) : Double
}