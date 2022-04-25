fun main() {
    val sourceStr = "F2p)v\"y233{0->c}ttelciFc"
    val firstPartString =
        devString(sourceStr = sourceStr, startIndex = 0, endIndex = sourceStr.length / 2)
    val secondPartString =
        devString(sourceStr = sourceStr, startIndex = sourceStr.length / 2, endIndex = sourceStr.length)

//    Обработка переменной функционального типа
//    val shiftedString : (sourceStr: String, shift: Int) -> String =
//        fun(sourceStr: String, shift: Int) : String = sourceStr.map { char -> char + shift }.joinToString("")
//
//    println("${shiftedString(decodeFirstPart(shiftedString(firstPartString, 1)), -3)
//        .replace(oldChar = '0', newChar = 'o')}\n" +
//            decodeSecondPart(shiftedString(secondPartString.reversed(), -4)))

//    Обработка функцией высшего порядка
    println("${shift(decodeFirstPart(shift(firstPartString, shift = 1)), shift = -3)
        .replace(oldChar = '0', newChar = 'o')}\n" +
            decodeSecondPart(shift(secondPartString.reversed(), shift = -4)))
}

fun devString(sourceStr: String, startIndex: Int, endIndex: Int) : String = sourceStr.substring(startIndex, endIndex)

fun decodeFirstPart(string: String) : String {
    return string.replace(oldChar = '5', newChar = 's')
        .replace(oldChar = '4', newChar = 'u')
}

fun decodeSecondPart(string: String): String {
    return string.replace(oldChar = '_', newChar = ' ')
}

fun shift(shiftedString: String,
          shift: Int,
          shiftChar: ((shiftedStr: String, shift: Int) -> String)? = null
): String {
    shiftChar?.invoke(shiftedString, shift)
    return shiftedString.map { char -> char + shift }.joinToString("")
}