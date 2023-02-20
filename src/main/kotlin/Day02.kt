import java.io.File

fun main() {
    val num = 125698
    println(num % 3)
    val input = File("src/main/resources/Day02.txt").readText().split("\n")
    var score = 0

    for (i in input) {
        val opp = i[0]
        val home = i[2]

        when(home) {
            'X' -> {
                when(opp) {
                    'A' -> score += 3
                    'B' -> score += 1
                    'C' -> score += 2
                }
            }
            'Y' ->  {
                score += 3
                when(opp) {
                    'A' -> score += 1
                    'B' -> score += 2
                    'C' -> score += 3
                }
            }
            'Z' -> {
                score += 6
                when (opp) {
                    'A' -> score += 2
                    'B' -> score += 3
                    'C' -> score += 1
                }
            }
        }
    }
}