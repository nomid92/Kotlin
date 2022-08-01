fun main() {
    val wheel = Wheel()
    testWork(wheel = wheel, pressure = -5.0)
    testWork(wheel = wheel, pressure = 1.4)
    testWork(wheel = wheel, pressure = 2.6)
    testWork(wheel = wheel, pressure = 5.0)
    testWork(wheel = wheel, pressure = 10.0)
    testWork(wheel = wheel, pressure = 10.1)
    testWork(wheel = wheel, pressure = 11.0)
    testWork(wheel = wheel, pressure = 2.2)
}

fun testWork(wheel: Wheel, pressure: Double) {
    val workResult: Result<Double> = runCatching {
        wheel.pumpUp(pressure = pressure)
        wheel.checkPressure()
    }

    println(
        "Выполнено: " +
                if (workResult.isSuccess) {
                    "успешно" + "\n\tДавление составляет: ${workResult.getOrNull()} атмосфер\n"
                } else {
                    "неудачно" + "\n\t${workResult.exceptionOrNull()}\n"
                }
    )
}