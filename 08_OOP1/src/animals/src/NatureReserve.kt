class NatureReserve {

    private var listAnimals: Map<String, List<Animals>>

    init {
        val mutableListBird: MutableList<Bird> = mutableListOf()
        val mutableListFish: MutableList<Fish> = mutableListOf()
        val mutableListDog: MutableList<Dog> = mutableListOf()

        for (i: Int in 1..5) {
            mutableListBird.add(Bird(name = "Птица", maxAge = 3))
        }
        for (i: Int in 1..3) {
            mutableListFish.add(Fish(name = "Рыба", maxAge = 2))
        }
        for (i: Int in 1..2) {
            mutableListDog.add(Dog(name = "Собака", maxAge = 5))
        }

        listAnimals = mapOf(
            "Птицы" to mutableListBird.toList(),
            "Рыбы" to mutableListFish.toList(),
            "Собаки" to mutableListDog.toList()
        )
    }

    fun lifecycle() {

        listAnimals.forEach { (animal: String, listAnimal: List<Animals>) ->
            listAnimal.forEach(fun(it: Animals) {
                randomAction(it, listAnimals.getValue(animal))
            })
        }

        if (listAnimals.getValue(key = "Птицы").size +
            listAnimals.getValue(key = "Рыбы").size +
            listAnimals.getValue(key = "Собаки").size > 0
        ) {

            val allAnimals: MutableMap<String, List<Animals>> = mutableMapOf()

            listAnimals.forEach { (key: String, list: List<Animals>) ->
                run(fun() {
                    val allOfTypeAnimals: MutableList<Animals> = mutableListOf()
                    var count = 0

                    for (i: Int in 0..list.lastIndex) {
                        if (!list[i].isTooOld)
                            allOfTypeAnimals.add(list[i])
                        else count++
                    }

                    allAnimals[key] = allOfTypeAnimals

                    if (count != 0)
                        println("Умерли $key, количество: $count")
                })
            }

            listAnimals = allAnimals.toMap()

            println(
                "По окончании цикла в заповеднике:\n" +
                        "\tПтиц: ${listAnimals.getValue(key = "Птицы").size}" +
                        "\n\tРыб: ${listAnimals.getValue(key = "Рыбы").size}" +
                        "\n\tСобак: ${listAnimals.getValue(key = "Собаки").size}"
            )
        } else {
            println("В заповеднике нет животных")
        }
    }

    private fun randomAction(
        kindOfAnimal: Animals,
        kindOfListAnimal: List<Animals>,
        kindOfAnimalInvoke: ((Animals?, List<Animals>?) -> List<Animals>)? = null
    ) {
        kindOfAnimalInvoke?.invoke(kindOfAnimal, kindOfListAnimal)

        when ((1..4).random()) {
            1 -> kindOfAnimal.sleep()
            2 -> kindOfAnimal.eat()
            3 -> kindOfAnimal.move()
            4 -> {
                val newAnimal: Animals =
                    kindOfAnimal.multiply(name = kindOfAnimal.name, maxAge = kindOfAnimal.maxAge)

                val listAnimals: MutableList<Animals> = kindOfListAnimal.toMutableList()

                val string: String =
                    this.listAnimals.filterValues { it == kindOfListAnimal }.toMutableMap().keys.toList()[0]

                val allAnimals: MutableMap<String, List<Animals>> = this.listAnimals.toMutableMap()

                listAnimals.add(newAnimal)

                allAnimals.remove(string)

                allAnimals[string] = listAnimals

                this.listAnimals = allAnimals
            }
        }
    }
}
