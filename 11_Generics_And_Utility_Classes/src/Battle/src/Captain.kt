class Captain : AbstractWarrior() {
    override val maxHealth: Int = 3000
    override val dodge: Int = 5
    override val accuracy: Int = 30
    override var weapon: AbstractWeapon = Weapons.automatic
    override var currentHealth: Int = maxHealth
    override var isKilled: Boolean = false

    //Смена оружия (автомат <-> СВД)
    fun changeWeapon() {
        when (weapon) {
            Weapons.svd -> {
                weapon = Weapons.automatic
            }

            Weapons.automatic -> {
                weapon = Weapons.svd
            }
        }
    }

    override fun printState() {
        println("Воин: Капитан")
        super.printState()
        println()
    }
}
