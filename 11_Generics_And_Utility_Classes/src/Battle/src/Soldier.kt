class Soldier(override val weapon: AbstractWeapon = Weapons.pistol) : AbstractWarrior() {
    override val maxHealth: Int = 2000
    override val dodge: Int = 3
    override val accuracy: Int = 20
    override var currentHealth: Int = maxHealth
    override var isKilled: Boolean = false

    override fun printState() {
        println("Воин: Солдат")
        super.printState()
        println()
    }
}