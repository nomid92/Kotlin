import kotlin.random.Random

open class Animals(

    val name: String,
    val maxAge: Int,
    var energy: Int = (1..10).random(),
    var weight: Int = Random.nextInt(1, 5)
) {

    private var currentAge: Int = 0
    var isTooOld: Boolean = currentAge >= maxAge

    fun sleep() {
        energy += 5
        tryIncrementAge()
        println("$name спит")
    }

    fun eat() {
        energy += 3
        weight++
        tryIncrementAge()
        println("$name ест")
    }

    open fun move() {
        when {
            energy - 5 >= 0 && weight - 1 > 1 -> {
                energy -= 5
                weight--
                tryIncrementAge()
                println("$name передвигается")
            }

            energy - 5 < 0 -> println(
                "Не хватает энергии\n\t" +
                        "$name,\tэнергия: $energy,\tвес: $weight"
            )

            weight - 1 <= 1 -> println(
                "Не хватает веса\n\t" +
                        "$name,\tэнергия: $energy,\tвес: $weight"
            )
        }
    }

    open fun multiply(
        name: String = this.name,
        maxAge: Int = this.maxAge
    ): Animals {

        val newAnimals = Animals(name, maxAge)

        println(
            "Родилась: $name" +
                    "\n\tмаксимальный возраст: $maxAge" +
                    "\n\tэнергия: $energy" +
                    "\n\tВес: $weight"
        )

        return newAnimals
    }

    private fun tryIncrementAge() {
        if (Random.nextBoolean())
            currentAge++
        isTooOld = currentAge >= maxAge
    }
}