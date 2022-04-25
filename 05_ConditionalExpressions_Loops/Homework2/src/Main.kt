fun main() {
    println("Введите целое положительное число")
    val n: Int = getIntPositiveValue(readLine()?.toIntOrNull())
    val listFibonacci: MutableList<Int> = mutableListOf()
    getSequenceFibonacci(n, listFibonacci)
    println("n = ${listFibonacci.lastIndex + 1}\n" +
            "Значение числа в последовательности: ${listFibonacci[listFibonacci.lastIndex]}\n")

    var firstNumber = 0
    var secondNumber = 1
    var i = 2
    if (n <= 2) {
        println("n = ${n}\n" +
                "Значение числа в последовательности: ${1}")
    } else {
        while (i <= n) {
            val temp: Int = firstNumber
            firstNumber = secondNumber
            secondNumber += temp
            i++
        }

        println("n = ${n}\n" +
                "Значение числа в последовательности Фибоначи: $secondNumber")
    }
}

/**
 * @param inputPositiveIntValue Value to check for positivity and integer
 * @return Positivity and integer value from console's input
 */
tailrec fun getIntPositiveValue(inputPositiveIntValue: Int?,
                                inputPositiveFun: ((inputPositiveInt: Int?) -> Int?)? = null
) : Int {
    inputPositiveFun?.invoke(inputPositiveIntValue)
    return when {
        inputPositiveIntValue !is Int -> {
            println("Введенное значение не является числовым и(или) целочисленным\n" +
                    "Введите целое положительное число")
            getIntPositiveValue(readLine()?.toIntOrNull())
        }
        inputPositiveIntValue <= 0 -> {
            println("Введенное значение не является целочисленным и(или) положительным\n" +
                    "Введите целое положительное число")
            getIntPositiveValue(readLine()?.toIntOrNull())
        }
        else -> inputPositiveIntValue
    }
}

/**
 * @param numberInSequence Number in sequence Fibonacci for checked value
 * @param currentN Number current (n) checked value
 * @param startValueInSequence n - 1 value in sequence Fibonacci
 * @param currentValue current value in sequence Fibonacci
 * @return value in sequence Fibonacci for n number (first number is 1 in sequence)
 */
fun getSequenceFibonacci(numberInSequence: Int,
                         mutableList: MutableList<Int>,
                         currentN: Int = 0,
                         startValueInSequence: Int = 0,
                         currentValue: Int = 1,
                         getNumberValueInSequence: ((numberInSequence: Int,
                                                     mutableList: MutableList<Int>,
                                                     currentN: Int,
                                                     startValueInSequence: Int,
                                                     currentValue: Int) -> Int)? = null
) : Int {
    getNumberValueInSequence?.invoke(numberInSequence, mutableList, currentN, startValueInSequence, currentValue)
    return if (currentN < numberInSequence){
        val newCurrentValue: Int = currentValue + startValueInSequence
        mutableList.add(currentN, currentValue)
        getSequenceFibonacci(numberInSequence = numberInSequence,
            mutableList = mutableList,
            currentN = currentN + 1,
            startValueInSequence = currentValue,
            currentValue = newCurrentValue)
        currentValue
    } else 0
}