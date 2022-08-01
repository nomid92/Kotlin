open class BattleState()  {
    constructor(state: String) : this() {
        println(state)
    }

    object StateBattle : BattleState()

    object FirstTeamWin : BattleState(state = "Победила первая команда")

    object SecondTeamWin : BattleState(state = "Победила вторая команда")

    object Draw : BattleState(state = "Ничья")

    fun state(battle: Battle) {
        println("Состояние перавой команды")
        if (battle.firstTeam.deadTeam())
            println("\tкоманда уничтожена")
        else
            println("\tв команде есть дееспособные войны")
        enumWarrior(battle.firstTeam)
        println()

        println("Состояние второй команды")
        if (battle.secondTeam.deadTeam())
            println("\tкоманда уничтожена")
        else
            println("\tв команде есть дееспособные войны")
        enumWarrior(battle.secondTeam)
    }
}

fun enumWarrior(team: Team) {
    for (i: Int in team.teamWarrior.indices) {
        print("${i + 1}:\t")
        team.teamWarrior[i].printState()
    }
}

