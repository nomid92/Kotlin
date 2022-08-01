import kotlin.random.Random

class Battle {
    val firstTeam: Team = Team()
    val secondTeam: Team = Team()

    var finishedBattle: Boolean = false

    fun stateBattle() {
        BattleState.StateBattle.state(this)
    }

    fun nextRound() {
        val tempIsFirstTeamWin: Boolean = attackOtherTeam(firstTeam, secondTeam)
        val tempIsSecondTeamWin: Boolean = attackOtherTeam(secondTeam, firstTeam)

        when {
            tempIsFirstTeamWin && tempIsSecondTeamWin -> {
                BattleState.Draw
                this.finishedBattle = true
            }

            tempIsFirstTeamWin && !tempIsSecondTeamWin -> {
                BattleState.FirstTeamWin
                this.finishedBattle = true
            }

            !tempIsFirstTeamWin && tempIsSecondTeamWin -> {
                BattleState.SecondTeamWin
                this.finishedBattle = true
            }

            !tempIsFirstTeamWin && !tempIsSecondTeamWin -> {
                this.finishedBattle = false
            }
        }
    }
}

fun attackOtherTeam(firstTeam: Team, secondTeam: Team): Boolean {

    val indexesOfIsNotKilledWarrior = mutableListOf<Int>()
    for (i: Int in secondTeam.teamWarrior.indices) {
        if (!secondTeam.teamWarrior[i].isKilled)
            indexesOfIsNotKilledWarrior.add(i)
    }
    var i = 0
    while (i < firstTeam.teamWarrior.size) {
        if (!firstTeam.teamWarrior[i].isKilled) {
            for (j: Int in 0 until indexesOfIsNotKilledWarrior.size - 1) {
                if (secondTeam.teamWarrior[indexesOfIsNotKilledWarrior[j]].isKilled)
                    indexesOfIsNotKilledWarrior.remove(j)
            }

            if (indexesOfIsNotKilledWarrior.size > 0) {
                val tempRandom: Int = Random.nextInt(until = indexesOfIsNotKilledWarrior.size)
                firstTeam.teamWarrior[i].attack(
                    warrior = secondTeam.teamWarrior[indexesOfIsNotKilledWarrior[tempRandom]]
                )
                if (indexesOfIsNotKilledWarrior.size == 1
                    && secondTeam.teamWarrior[indexesOfIsNotKilledWarrior[tempRandom]].isKilled
                ) return true
            }
        }
        i++
    }
    return false
}