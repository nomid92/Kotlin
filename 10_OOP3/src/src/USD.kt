class USD : CurrencyConverter {

    override val currencyCode: String = "840"
        get

    override fun convertToRub(count: Double): Double {
        return count * 81.12
    }
}