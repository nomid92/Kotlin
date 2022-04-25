class BYN : CurrencyConverter {

    override val currencyCode: String = "933"
        get

    override fun convertToRub(count: Double): Double {
        return count * 24.25
    }
}