object Weapons {
    //Пистолет
    val pistol: AbstractWeapon =
        object : AbstractWeapon(maxAmmo = 8, fireType = FireType.SingleShot){
            override val name = "пистолет"

            override fun createAmmo(): Ammo {
                return Ammo.PistolAmmo
            }
        }

    //Автомат
    val automatic:  AbstractWeapon =
        object : AbstractWeapon(maxAmmo = 30, fireType = FireType.BurstShot(burstShot = 3)){
            override val name = "автомат"

            override fun createAmmo(): Ammo {
                return Ammo.AutomaticAmmo
            }
        }

    //Снайперская винтовка
    val svd: AbstractWeapon =
        object : AbstractWeapon(maxAmmo = 5, fireType = FireType.SingleShot) {
            override val name = "снайперская винтовка"

            override fun createAmmo(): Ammo {
                val tempAutomaticAmmo = Ammo.AutomaticAmmo
                tempAutomaticAmmo.coeffCriticalDamage = 10
                return tempAutomaticAmmo
            }
        }

    //Гранатомет
    val rgd:  AbstractWeapon =
        object : AbstractWeapon(maxAmmo = 1, fireType = FireType.SingleShot){
            override val name = "гранатомет"

            override fun createAmmo(): Ammo {
                return Ammo.Rocket
            }
        }
}