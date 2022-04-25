import java.util.*
import kotlin.math.roundToInt

fun main() {
//******    Проверка кредитной карты CashBachCard
    print("**************** Проверка кредитной карты CashBachCard ****************\n" +
            "Укажите сумму пополнения при открытии счета карты: ")
    var balance: Double = getDoublePositiveValue(readLine()?.toDoubleOrNull())

    print("Укажитекредитный лимит карты: ")
    var creditLimit: Int = getIntPositiveValue(readLine()?.toIntOrNull())

    val creditCashBachCard = CashBachCard(balance, creditLimit)
    creditCard(creditCashBachCard)
    println()

//******    Проверка кредитной карты creditCashBackCardSum
    print("**************** Проверка кредитной карты creditCashBackCardSum ****************\n" +
            "Укажите сумму пополнения при открытии счета карты: ")
    balance = getDoublePositiveValue(readLine()?.toDoubleOrNull())

    print("Укажитекредитный лимит карты: ")
    creditLimit = getIntPositiveValue(readLine()?.toIntOrNull())

    val creditCashBackCardSum = CashBackCardSum(balance, creditLimit)
    creditCard(creditCashBackCardSum)
    println()

//******    Проверка дебетовой карты DebitCardBonus
    print("**************** Проверка дебетовой карты DebitCardBonus ****************\n" +
            "Укажите сумму пополнения при открытии счета карты: ")
    val debitCardBonus = DebitCardBonus(getDoublePositiveValue(readLine()?.toDoubleOrNull()))
    debitCardBonus(debitCardBonus)
    println()


//******    Проверка дебетовой карты DebitCardBonus
    print("**************** роверка дебетовой карты DebitCardDeposit ****************\n" +
            "Укажите сумму пополнения при открытии счета карты: ")
    balance = getDoublePositiveValue(readLine()?.toDoubleOrNull())
    val calendar: Calendar = Calendar.getInstance()

    print("Укажите день месяца открытия счета: ")
    val day = getIntPositiveValue(readLine()?.toIntOrNull())

    print("Укажите месяца открытия счета: ")
    val month = getIntPositiveValue(readLine()?.toIntOrNull())

    print("Укажите год открытия счета: ")
    val year = getIntPositiveValue(readLine()?.toIntOrNull())
    calendar.set(year, month, day)
    var debitCardDeposit = DebitCardDeposit(balance, calendar)
    debitCardDeposit = debitCardDeposit(debitCardDeposit)
    debitCardDeposit.getAvailable()
}

fun creditCard(
    creditCard: CreditCard,
    cardInvoke: ((creditCard: CreditCard) -> Unit)? = null
) {
    cardInvoke?.invoke(creditCard)

    creditCard.getAvailable()
    print("Укажите стоимость покупки: ")
    creditCard.pay(getDoublePositiveValue(readLine()?.toDoubleOrNull()))

    print("Укажите сумму пополнения: ")
    creditCard.append(getDoublePositiveValue(readLine()?.toDoubleOrNull()))

    print("Укажите стоимость покупки: ")
    creditCard.pay(getDoublePositiveValue(readLine()?.toDoubleOrNull()))
    creditCard.getAvailable()

    print("Укажите сумму пополнения: ")
    creditCard.append(getDoublePositiveValue(readLine()?.toDoubleOrNull()))
    creditCard.getAvailable()

    print("Укажите сумму пополнения: ")
    creditCard.append(getDoublePositiveValue(readLine()?.toDoubleOrNull()))
    creditCard.getAvailable()
}

fun debitCardBonus(
    debitCard: DebitCardBonus,
    cardInvoke: ((debitCard: DebitCardBonus) -> Unit)? = null
) {
    cardInvoke?.invoke(debitCard)

    debitCard.getAvailable()
    print("Укажите стоимость покупки: ")
    debitCard.pay(getDoublePositiveValue(readLine()?.toDoubleOrNull()))

    print("Укажите сумму пополнения: ")
    debitCard.append(getDoublePositiveValue(readLine()?.toDoubleOrNull()))

    print("Укажите стоимость покупки: ")
    debitCard.pay(getDoublePositiveValue(readLine()?.toDoubleOrNull()))
    debitCard.getAvailable()

    print("Укажите сумму пополнения: ")
    debitCard.append(getDoublePositiveValue(readLine()?.toDoubleOrNull()))
    debitCard.getAvailable()

    print("Укажите стоимость покупки: ")
    debitCard.payBalance(getDoublePositiveValue(readLine()?.toDoubleOrNull()))
    debitCard.getAvailable()
}

fun debitCardDeposit(
    debitCard: DebitCardDeposit,
    cardInvoke: ((debitCard: DebitCardDeposit) -> Unit)? = null
): DebitCardDeposit {
    cardInvoke?.invoke(debitCard)

    val tempDebitCard: DebitCardDeposit = debitCard
    tempDebitCard.getAvailable()
    print("Укажите стоимость покупки: ")
    tempDebitCard.pay(getDoublePositiveValue(readLine()?.toDoubleOrNull()))

    print("Укажите сумму пополнения: ")
    tempDebitCard.append(getDoublePositiveValue(readLine()?.toDoubleOrNull()))

    print("Укажите стоимость покупки: ")
    tempDebitCard.pay(getDoublePositiveValue(readLine()?.toDoubleOrNull()))
    tempDebitCard.getAvailable()

    while (tempDebitCard.nextCapitalisation < Calendar.getInstance()) {
        tempDebitCard.capitalisation()
        tempDebitCard.nextCapitalisation.add(Calendar.MONTH, 1)
    }
    return tempDebitCard
}

fun getDoublePositiveValue(
    inputPositiveIntValue: Double?,
    inputPositiveFun: ((inputPositiveInt: Double?) -> Double?)? = null
): Double {
    inputPositiveFun?.invoke(inputPositiveIntValue)
    return when {
        inputPositiveIntValue !is Double -> {

            println(
                "Введенное значение не является числовым\n" +
                        "Введите положительное число (установлена точьность до сотых частей)"
            )
            getDoublePositiveValue(readLine()?.toDoubleOrNull())
        }

        inputPositiveIntValue <= 0 -> {

            println(
                "Введенное значение не является положительным\n" +
                        "Введите положительное число (установлена точьность до сотых частей)"
            )
            getDoublePositiveValue(readLine()?.toDoubleOrNull())
        }

        else -> (inputPositiveIntValue * 100).roundToInt() / 100.0
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