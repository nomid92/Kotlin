import kotlin.random.Random
import kotlin.random.nextInt

class Team {
    var teamWarrior: List<AbstractWarrior> = listOf()

    init {
        val tempTeamWarrior: MutableList<AbstractWarrior> = mutableListOf()
        for (i: Int in 0 .. 4) {
            val tempRandom = Random.nextInt(0..100)
            when {
                tempRandom > 40 -> {
                    tempTeamWarrior.add(Soldier())
                }
                tempRandom in 11..40 -> {
                    val tempCaptain = Captain()
                    if (50.criticalDamageAndDodge()) {
                        tempTeamWarrior.add(tempCaptain)
                    }
                    else {
                        tempCaptain.changeWeapon()
                        tempTeamWarrior.add(tempCaptain)
                    }
                }
                tempRandom <= 10 -> {
                    tempTeamWarrior.add(General())
                }
            }
        }
        teamWarrior = tempTeamWarrior.toList()
    }

    fun deadTeam(): Boolean {
        var countDead = 0
        for (element: AbstractWarrior in this.teamWarrior) {
            if (element.isKilled)
                countDead++
        }
        return countDead == this.teamWarrior.size
    }
}