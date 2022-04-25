class UAH : CurrencyConverter {

    override val currencyCode: String = "980"
        get

    override fun convertToRub(count: Double): Double {
        return count * 2.73
    }
}