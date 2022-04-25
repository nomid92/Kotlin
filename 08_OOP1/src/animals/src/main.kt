fun main() {
    val natureReserve = NatureReserve()

    println("Введите количество жизненых циклов заповедника")

    val n: Int = getIntPositiveValue(readLine()?.toIntOrNull())

    for (i: Int in 1..n) {
        println("$i жизненный цикл заповедника:")
        natureReserve.lifecycle()
    }
}

fun getIntPositiveValue(
    inputPositiveIntValue: Int?,
    inputPositiveFun: ((inputPositiveInt: Int?) -> Int?)? = null
): Int {
    inputPositiveFun?.invoke(inputPositiveIntValue)

    return when {
        inputPositiveIntValue !is Int -> {

            println(
                "Введенное значение не является числовым и(или) целочисленным\n" +
                        "Введите целое положительное число"
            )
            getIntPositiveValue(readLine()?.toIntOrNull())
        }

        inputPositiveIntValue <= 0 -> {

            println(
                "Введенное значение не является целочисленным и(или) положительным\n" +
                        "Введите целое положительное число"
            )
            getIntPositiveValue(readLine()?.toIntOrNull())
        }

        else -> inputPositiveIntValue
    }
}