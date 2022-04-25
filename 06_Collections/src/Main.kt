fun main() {
    println("Введите число n:")
    val n: Int = getIntPositiveValue(readLine()?.toIntOrNull())

    val listTelephoneNumber: List<String> = inputTelephoneNumber(n)

    println("Номера телефонов, начинающиеся с +7:\n" +
            "${listTelephoneNumber.filter { it.substring(0, 2) == "+7" }}")

    println("Количество номеров телефонов без павторов - ${listTelephoneNumber.toSet().size}:\n" +
            "${listTelephoneNumber.toSet()}")

    var sum = 0
    listTelephoneNumber.forEach {
        sum += it.length
    }

    println("Список состоит из $sum символов")

    val mutListTelephoneBook: MutableList<Pair<String, String>> = mutableListOf()
    listTelephoneNumber.toSet().forEach{
        print("Введите имя человека с номером телефона $it: ")
        mutListTelephoneBook.add(it to readLine().toString())
    }

    val listTelephoneBook: List<Pair<String, String>> = mutListTelephoneBook.toList()
    listTelephoneBook.forEach{ (key: String, value : String) ->
        run{
            println("Абонент: $value. Номер телефона: $key")
        }
    }

    println(listTelephoneBook.toSortedSet(compareBy{ it.first }))
    println(listTelephoneBook.toSortedSet(compareBy { it.second }))
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
 * @param telephoneNumber String with number phone for check validly input
 * @return String in format "+<number of phone>"
 */
fun checkValidTelephoneNumber(telephoneNumber: String?,
                              inputTelephone: ((number: String) -> String)? = null) : String {
    if (telephoneNumber != null) {
        inputTelephone?.invoke(telephoneNumber)
    }
    return when (telephoneNumber) {
        null -> {
            println("Вы не ввели никакого значения\n" +
                    "Введите номер телефона:")
            checkValidTelephoneNumber(readLine())
        }
        else -> {
            val regex: Sequence<MatchResult> = Regex(pattern = """\D""").findAll(telephoneNumber)
            val listCharIncorrect: List<String> = regex.groupBy { it.groupValues[0] }.keys.toList()

            val incorrectChar: MutableMap<Int, Char> = mutableMapOf()
            telephoneNumber.filterIndexed { index, char ->
                if (char == '+') incorrectChar[index] = char
                telephoneNumber[index] == '+'
            }
            when {
                listCharIncorrect.size > 1
                        || incorrectChar.size > 1 -> {
                    outputMessage()
                }
                listCharIncorrect.size == 1 -> {
                    if (incorrectChar[0] == '+'
                        && incorrectChar.values.toSet().count() == 1) "$telephoneNumber"
                    else outputMessage()
                }
                else -> "+$telephoneNumber"
            }
        }
    }
}

/**
 * @return String in format "+<number of phone>"
 */
fun outputMessage() : String {
    println("Вы ввели некорректный номер телефона\n" +
            "Введите номер телефона заново:")
    return checkValidTelephoneNumber(readLine())
}

/**
 * @param n numbers of phone number for input
 * @return list of input phone numbers
 */
fun inputTelephoneNumber(n: Int = 1,
                         inputTelephone: ((n: Int) -> List<String>)? = null) : List<String> {
    inputTelephone?.invoke(n)

    val telephoneNumbers: MutableList<String> = mutableListOf()
    for (i: Int in 1 .. n) {
        println("Ведите $i из $n номер телефона:")
        telephoneNumbers.add(index = i - 1, element = checkValidTelephoneNumber(readLine()))
    }
    return telephoneNumbers
}