fun main() {
    val currency = object : Converters {
        val usd = USD()
        val eur = EUR()
        val byn = BYN()
        val uah = UAH()

        override fun get(currencyCode: String) : CurrencyConverter {
            return when (currencyCode){
                "840" -> usd
                "978" -> eur
                "933" -> byn
                "980" -> uah
                else -> {
                    object : CurrencyConverter {
                        override val currencyCode: String = currencyCode

                        override fun convertToRub(count: Double): Double {
                            return 0.0
                        }
                    }
                }
            }
        }

        override fun convertToRub(currencyCode: String, count: Double, rate: Double): Double {
            return count * rate
        }
    }

    println("150 USD = " + currency.get("840").convertToRub(150.0) + " RUB")
    println("129.45 EUR = " + currency.get("978").convertToRub(129.45) + " RUB")
    println("24.86 BYN = " + currency.get("933").convertToRub(24.86) + " RUB")
    println("27 UAH = " + currency.get("980").convertToRub(27.0) + " RUB")

    println()
    print("Укажите код валюты: ")
    val tempCurrency = readLine().toString()
    print("Укажите количество для конвертации: ")
    val tempCount = readLine()!!.toDouble()
    print("Укажите курс валюты к рублю: ")
    val tempRate = readLine()!!.toDouble()
    println("$tempCount $tempCurrency = " + currency.convertToRub("456", tempCount, tempRate) + " RUB")
}

interface Converters {
    fun get(currencyCode: String) : CurrencyConverter

    fun convertToRub(currencyCode: String, count: Double, rate: Double): Double
}