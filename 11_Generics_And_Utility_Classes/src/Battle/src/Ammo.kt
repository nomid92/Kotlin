import kotlin.random.Random
import kotlin.random.nextInt

enum class Ammo(
    val damage: Int,
    var chanceCriticalDamage: Boolean,
    var coeffCriticalDamage: Int
) {

    //Патрон для пистолета
    PistolAmmo(
        damage = 50,
        chanceCriticalDamage = false,
        coeffCriticalDamage = 3
    ),

    //Патрон для автомата и СВД
    AutomaticAmmo(
        damage = 100,
        chanceCriticalDamage = false,
        coeffCriticalDamage = 2
    ),

    //Заряд для РГД
    Rocket(
        damage = 800,
        chanceCriticalDamage = false,
        coeffCriticalDamage = 5
    );

    //Получение текущего урона патроном
    fun getCurrentDamage(): Int {
        return if (chanceCriticalDamage) damage * coeffCriticalDamage else damage
    }
}

//Вычисление случайного критического урона
fun Int.criticalDamageAndDodge(): Boolean {
    return this >= Random.nextInt(1 .. 100)
}