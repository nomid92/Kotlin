class Fish(name: String, maxAge: Int) : Animals(name, maxAge) {

    override fun move() {

        super.move()

        if (energy - 5 >= 0 && weight - 1 > 1)
            println("\tплывет")
    }

    override fun multiply(name: String, maxAge: Int): Fish {

        val newFish = Fish(name, maxAge)

        println(
            "Родилась: $name" +
                    "\n\tмаксимальный возраст: ${newFish.maxAge}" +
                    "\n\tэнергия: ${newFish.energy}" +
                    "\n\tВес: ${newFish.weight}"
        )

        return newFish
    }
}