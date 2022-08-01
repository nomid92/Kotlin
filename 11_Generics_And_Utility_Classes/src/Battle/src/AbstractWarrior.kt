abstract class AbstractWarrior : Warrior {
    abstract val maxHealth: Int
    abstract override val dodge: Int
    abstract val accuracy: Int
    abstract val weapon: AbstractWeapon
    abstract var currentHealth: Int

    override fun attack(warrior: AbstractWarrior) {
        if (!weapon.isAmmoInMagazine) {
            weapon.recharge()
        } else {
            val tempListAmmo: List<Ammo> = weapon.getAmmo()

            for (i: Int in tempListAmmo.indices) {
                when (this) {
                    is General -> {
                        tempListAmmo[i].chanceCriticalDamage = 60.criticalDamageAndDodge()
                    }
                    is Captain -> {
                        tempListAmmo[i].chanceCriticalDamage = 40.criticalDamageAndDodge()
                    }
                    is Soldier -> {
                        tempListAmmo[i].chanceCriticalDamage = 25.criticalDamageAndDodge()
                    }
                }

                warrior.takeDamage(tempListAmmo[i].getCurrentDamage())
            }
        }
    }

    //Получение урона
    override fun takeDamage(damage: Int) {
        if (currentHealth - damage <= 0) {
            isKilled = true
            currentHealth = 0
        } else {
            currentHealth -= damage
        }
    }

    //Вывод текущего состояния
    override fun printState() {
        print(
            "\tТекущее здоровье: $currentHealth,\tОружие: ${weapon.name},\t" +
                    "Патронов до перезарядки: ${weapon.magazineAmmo.size}/${weapon.maxAmmo}."
        )
    }
}

