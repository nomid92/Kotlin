class Bird(name: String, maxAge: Int) : Animals(name, maxAge) {

    override fun move() {

        super.move()

        if (energy - 5 >= 0 && weight - 1 > 1)
            println("\tлетит")
    }

    override fun multiply(name: String, maxAge: Int): Bird {

        val newBird = Bird(name, maxAge)

        println(
            "Родилась: $name" +
                    "\n\tмаксимальный возраст: ${newBird.maxAge}" +
                    "\n\tэнергия: ${newBird.energy}" +
                    "\n\tВес: ${newBird.weight}"
        )

        return newBird
    }
}