fun main() {
    val firstName = "Дмитрий"
    val lastName = "Пискун"
    var height = 1.8
    var weight = 67f
    var isChild = height < 1.5 || weight < 40
    var info = "Имя: ${firstName},\tФамилия: ${lastName},\tРост: ${height},\tВес: ${weight},\tРебенок?: ${isChild}"
    println(info)

    height = 2.01
    info = "Имя: ${firstName},\tФамилия: ${lastName},\tРост: ${height},\tВес: ${weight},\tРебенок?: ${isChild}"
    println(info)
    height = 1.47
    weight = 41f
    isChild = height < 1.5 || weight < 40
    info = "Имя: ${firstName},\tФамилия: ${lastName},\tРост: ${height},\tВес: ${weight},\tРебенок?: ${isChild}"
    println(info)
}