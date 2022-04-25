import kotlin.random.Random

class TV(
    val brend: String,
    val model: String,
    val diagonal: Int = 32,
    var listOfChannelsTV: List<Pair<Int, String>> = listOf()
) {
    constructor(descriptor: Pair<String, String>, diagonal: Int) : this(
        brend = descriptor.first,
        model = descriptor.second,
        diagonal = diagonal
    )

    init {
        listOfChannelsTV = Channels.getRandomChannels(Random.nextInt(1, 32))
    }

    var isWork = true

    var isMute = true
        get

    var volume = 10
        get

    var currentChannel = 1
        get
        set(channel) {
            if (isWork) field = channel else isWork = true
        }

    /**
     * function added 1 unit volume
     */
    fun addVolume() {
        if (isMute) {

            if (volume + 1 < maxVolume) {
                volume++
                println("Уровенть громкисти максимальный. Уровень громкости $volume ед.")
            } else {
                volume = maxVolume
                println("Увеличение громкисти на 1 единиу. Уровень громкости $volume ед.")
            }
        } else println("Громкость отключена")
    }

    /**
     * function reduced 1 unit volume
     */
    fun reduceVolume() {
        if (isMute) {

            if (volume - 1 >= 0) {
                volume--
                println("Уменьшение громкисти на 1 единиу. Уровень громкости $volume ед.")
            } else {
                volume = 0
                println("Уровенть громкисти минимальный. Уровень громкости $volume ед.")
            }
        } else println("Громкость отключена")
    }

    /**
     * function on/off volume for TV
     */
    fun mute() {
        isMute = !isMute
        println(
            "Включение/отключение громкисти. Громкость " +
                    if (isMute) "включена, уровень громкости $volume ед." else "отключена"
        )
    }

    /**
     * function set currentChannel channel
     * @param channel number of channel
     */
    fun setChannel(
        channel: Int?,
        inputChannel: ((channel: Int?) -> Int)? = null
    ) {
        inputChannel?.invoke(channel)

        val newChannel: Int = inputChannel(channel)

        if (!isWork) {
            setIsWorkTV()
            println("Текущий канал $currentChannel - ${listOfChannelsTV[currentChannel - 1].second}")
        } else

            if (newChannel > listOfChannelsTV.size || newChannel <= 0) {

                println(
                    "Указанный канал не настроен. Текущий канал " +
                            "$currentChannel - ${listOfChannelsTV[currentChannel - 1].second}" +
                            "выберите канал из списка: "
                )

                listOfChannelsTV.forEach { (numberChannel: Int, Name: String) ->
                    println("$numberChannel - $Name")
                }

                setChannel(inputChannel(readLine()?.toIntOrNull()))

            } else {
                currentChannel = newChannel

                println(
                    "Переключение на указанный канал. Текущий канал $currentChannel" +
                            " - ${listOfChannelsTV[currentChannel - 1].second}"
                )
            }
    }

    /**
     * function added 1 channel for currentChannel
     */
    fun changePlusChannel() {
        if (!isWork) {

            setIsWorkTV()
            println(
                "Текущий канал $currentChannel" +
                        " - ${listOfChannelsTV[currentChannel - 1].second}"
            )

        } else {

            if (listOfChannelsTV.size >= currentChannel + 1) currentChannel++
            else currentChannel = 1

            println(
                "Переключение на 1 канал вверх. Текущий канал $currentChannel" +
                        " - ${listOfChannelsTV[currentChannel - 1].second}"
            )
        }
    }

    /**
     * function reduced 1 channel for currentChannel
     */
    fun changeMinusChannel() {
        if (!isWork) {

            setIsWorkTV()
            println(
                "Текущий канал $currentChannel" +
                        " - ${listOfChannelsTV[currentChannel - 1].second}"
            )
        } else {

            if (1 <= currentChannel - 1) currentChannel--
            else currentChannel = listOfChannelsTV.size

            println(
                "Переключение на 1 канал вниз. Текущий канал $currentChannel" +
                        " - ${listOfChannelsTV[currentChannel - 1].second}"
            )
        }
    }

    /**
     * function on/off work TV
     */
    fun setIsWorkTV() {
        isWork = !isWork

        println("Телевизор " + if (isWork) "включен." else "выключен.")
    }

    /**
     * function control new number of channel in valid
     * @param inputNumberChannel input number of channel
     */
    private fun inputChannel(
        inputNumberChannel: Int?,
        numberChannel: ((inputNumberChannel: Int?) -> Int?)? = null
    ): Int {

        numberChannel?.invoke(inputNumberChannel)

        return when {
            inputNumberChannel !is Int -> {
                println(
                    "Введенное значение не является числовым и(или) целочисленным\n" +
                            "Введите номер канала"
                )
                inputChannel(readLine()?.toIntOrNull())
            }

            inputNumberChannel <= 0 -> {
                println(
                    "Нет отрицательных и нулевого канала\n" +
                            "Введите номер канала повторно"
                )
                inputChannel(readLine()?.toIntOrNull())
            }

            else -> {
                inputNumberChannel
            }
        }
    }

    /**
     * function show configure channels TV
     */
    fun getChannelsTV() {
        println("Каналы данного телевизора настроенны следующим образом:")

        listOfChannelsTV.forEach { (numberChannel: Int, nameChannel: String) ->
            println(message = "$numberChannel - $nameChannel")
        }
    }

    companion object {
        const val maxVolume: Int = 50
    }
}