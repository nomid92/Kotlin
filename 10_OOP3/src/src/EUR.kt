class EUR : CurrencyConverter {

    override val currencyCode: String = "978"
        get

    override fun convertToRub(count: Double): Double {
        return count * 87.45
    }
}