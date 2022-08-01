fun main() {

    val battle = Battle()
    battle.stateBattle()

    var i = 1
    while (i < 13) {
        if (battle.finishedBattle) {
            break
        } else {

            println("\nРаунд № $i завершен, состояние сражения:")
            battle.nextRound()
            i++
        }
        battle.stateBattle()
    }

    println()
    if (!battle.finishedBattle) {
        BattleState.Draw
    }

}


