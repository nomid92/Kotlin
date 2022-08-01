interface Warrior {
    var isKilled: Boolean
    val dodge: Int
    //Нанесение урона противнику
    fun attack(warrior: AbstractWarrior)

    //Полученный урон
    fun takeDamage(damage: Int)

    fun printState()
}