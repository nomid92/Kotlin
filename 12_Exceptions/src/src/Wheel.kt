class Wheel {
    var currentPressure: Double = 0.0

    fun pumpUp(pressure: Double) {
        when {
            pressure < 0.0 || pressure > 10.0 -> throw IncorrectPressure()

            pressure < 1.6 -> throw TooLowPressure()

            pressure > 2.5 -> throw TooHighPressure()

            else -> currentPressure = pressure
        }
    }

    fun checkPressure(): Double {
        when {
            currentPressure < 0.0 || currentPressure > 10.0 -> throw IncorrectPressure()

            currentPressure < 1.6 -> throw TooLowPressure()

            currentPressure > 2.5 -> throw TooHighPressure()

            else -> return currentPressure
        }
    }
}