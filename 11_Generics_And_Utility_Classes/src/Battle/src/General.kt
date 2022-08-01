class General(override val weapon: AbstractWeapon = Weapons.rgd) : AbstractWarrior() {
    override val maxHealth: Int = 4500
    override val dodge: Int = 10
    override val accuracy: Int = 50
    override var currentHealth: Int = maxHealth
    override var isKilled: Boolean = false

    override fun printState() {
        println("Воин: Генерал")
        super.printState()
        println()
    }
}