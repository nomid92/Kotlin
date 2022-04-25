fun main() {
    val firstTV = TV(descriptor = "Samsung" to "QN90A Neo QLED 4K Smart TV 2021", diagonal = 43)
    val secondTV = TV(brend = "LG", model = "32LM576BPLD")
    val thirdTV = TV(descriptor = "Xiaomi" to "Mi TV P1 55", diagonal = 55)

    println("Вы выбрали телевизор ${firstTV.brend} модель ${firstTV.model} диагональю ${firstTV.diagonal}\"")
    firstTV.getChannelsTV()

    for (i: Int in 0..6) firstTV.addVolume()
    firstTV.mute()

    for (i: Int in 0..2) firstTV.reduceVolume()
    firstTV.mute()
    for (i: Int in 0..20) firstTV.reduceVolume()

    for (i: Int in 0..8) firstTV.changePlusChannel()

    println("Телевизор ${if (firstTV.isWork) "включен" else "отключен"}")
    firstTV.setIsWorkTV()

    for (i: Int in 0..4) firstTV.changeMinusChannel()
    firstTV.currentChannel = 1

    print("Укажите на какой канал перекючить: ")
    firstTV.setChannel(readLine()?.toIntOrNull())

    println(
        "Состояние телевизора ${firstTV.brend} " +
                "модель ${firstTV.model} " +
                "диагональю ${firstTV.diagonal}:\n" +
                "Телевизор ${if (firstTV.isWork) "включен"
                else "отключен"};\n" +
                "Громкость ${if (firstTV.isMute) "включена"
                else "отключена"};\n" +
                "Уровени громкости ${firstTV.volume} единниц;\n" +
                "Текущий канал № ${firstTV.currentChannel}" +
                " - ${firstTV.listOfChannelsTV[firstTV.currentChannel - 1].second}"
    )


    println("\nВы выбрали телевизор ${secondTV.brend} модель ${secondTV.model} диагональю ${secondTV.diagonal}\"")
    secondTV.getChannelsTV()

    println("Телевизор ${if (secondTV.isWork) "включен" else "отключен"}")
    secondTV.setIsWorkTV()
    secondTV.currentChannel = 2

    for (i: Int in 0..7) secondTV.changeMinusChannel()
    for (i: Int in 0..46) secondTV.addVolume()
    secondTV.mute()

    for (i: Int in 0..2) secondTV.reduceVolume()
    secondTV.mute()
    for (i: Int in 0..13) secondTV.reduceVolume()

    for (i: Int in 0..14) secondTV.changePlusChannel()

    print("Укажите на какой канал перекючить: ")
    secondTV.setChannel(readLine()?.toIntOrNull())

    println(
        "Состояние телевизора ${secondTV.brend} " +
                "модель ${secondTV.model} " +
                "диагональю ${secondTV.diagonal}:\n" +
                "Телевизор ${if (secondTV.isWork) "включен"
                else "отключен"};\n" +
                "Громкость ${if (secondTV.isMute) "включена"
                else "отключена"};\n" +
                "Уровени громкости ${secondTV.volume} единниц;\n" +
                "Текущий канал № ${secondTV.currentChannel}" +
                " - ${secondTV.listOfChannelsTV[secondTV.currentChannel - 1].second}"
    )


    println("\nВы выбрали телевизор ${thirdTV.brend} модель ${thirdTV.model} диагональю ${thirdTV.diagonal}\"")
    thirdTV.getChannelsTV()

    thirdTV.currentChannel = 4
    for (i: Int in 0..7) thirdTV.changeMinusChannel()

    for (i: Int in 0..3) thirdTV.addVolume()
    thirdTV.mute()

    thirdTV.setIsWorkTV()
    println("Телевизор ${if (thirdTV.isWork) "включен" else "отключен"}")

    for (i: Int in 0..1) thirdTV.reduceVolume()
    thirdTV.mute()
    for (i: Int in 0..16) thirdTV.reduceVolume()

    for (i: Int in 0..5) thirdTV.changePlusChannel()

    print("Укажите на какой канал перекючить: ")
    thirdTV.setChannel(readLine()?.toIntOrNull())

    println(
        "Состояние телевизора ${thirdTV.brend} " +
                "модель ${thirdTV.model} " +
                "диагональю ${thirdTV.diagonal}:\n" +
                "Телевизор ${if (thirdTV.isWork) "включен"
                else "отключен"};\n" +
                "Громкость ${if (thirdTV.isMute) "включена"
                else "отключена"};\n" +
                "Уровени громкости ${thirdTV.volume} единниц;\n" +
                "Текущий канал № ${thirdTV.currentChannel}" +
                " - ${thirdTV.listOfChannelsTV[thirdTV.currentChannel - 1].second}"
    )
}