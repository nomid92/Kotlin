sealed class FireType {
    object SingleShot: FireType()
    data class BurstShot(val burstShot: Int): FireType()
}