class Dog(name: String, maxAge: Int) : Animals(name, maxAge) {

    override fun move() {

        super.move()

        if (energy - 5 >= 0 && weight - 1 > 1)
            println("\tбежит")
    }

    override fun multiply(name: String, maxAge: Int): Dog {

        val newDog = Dog(name, maxAge)

        println(
            "Родилась: $name" +
                    "\n\tмаксимальный возраст: ${newDog.maxAge}" +
                    "\n\tэнергия: ${newDog.energy}" +
                    "\n\tВес: ${newDog.weight}"
        )

        return newDog
    }
}