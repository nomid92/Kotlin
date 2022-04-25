object Channels {
    private val listChannels = listOf("Первый канал", "Россия 1", "МАТЧ! ТВ", "НТВ", "5 канал", "Россия К",
        "Россия 2", "Карусель", "ОТР", "ТВЦ", "РЕН-ТВ", "Спас", "СТС", "Домашний",
        "ТВ3", "Звезда", "Мир", "ТНТ", "МУЗ-ТВ", "Тверской проспект", "Югра",
        "Россия 1 HD", "Че", "2X2", "СТС Love", "Ю", "Первый канал HD", "Союз",
        "8 Канал", "МАТЧ! ТВ HD", "ТНТ-4", "ЮТВ")

    /**
     * function get random map of channels
     */
    fun getRandomChannels(countChannels: Int = 32): List<Pair<Int, String>> {
        val channels: MutableList<Pair<Int, String>> = mutableListOf()
        val listRandomChannels: List<Int> = (0..31).shuffled()

        for (i: Int in 0 until countChannels - 1){
            channels.add(i + 1 to listChannels[listRandomChannels[i]])
        }

        return channels.toList()
    }
}