abstract class AbstractWeapon(
    val maxAmmo: Int,
    private var fireType: FireType
) {
    abstract val name: String
    val magazineAmmo: Stack<Any> = Stack()
    val isAmmoInMagazine: Boolean
        get() = !magazineAmmo.isEmpty()

    //Создание патрона
    abstract fun createAmmo(): Ammo

    //Перезарядка магизина
    fun recharge() {
        for (i: Int in 0 until maxAmmo) {
            magazineAmmo.push(createAmmo())
        }
    }

    //Получение патрона для выстрела
    fun getAmmo(): List<Ammo> {
        val listAmmo: MutableList<Ammo> = mutableListOf()

        listAmmo.add(magazineAmmo.pop() as Ammo)
        if (fireType is FireType.BurstShot)
            for (i: Int in 1 until (fireType as FireType.BurstShot).burstShot) {
                val tempAmmo = magazineAmmo.pop() as Ammo?
                if (tempAmmo == null) {
                    break
                } else
                    listAmmo.add(tempAmmo)
            }

        return listAmmo.toList()
    }
}
