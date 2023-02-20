import java.io.File

fun main() {
    val input = File("src/main/resources/Day03.txt").readLines()
    var sum = 0
    var index = 0
    var first = ""
    var sec = ""
    var third = ""

    for (i in input) {
        when(index) {
            0 -> first = i
            1 -> sec = i
            2 -> third = i
        }
        if (index++ == 2) {
            val common = (first.toSet() intersect sec.toSet() intersect third.toSet()).single()
            sum += if (common in 'a'..'z') common - 'a' + 1
            else common - 'A' + 27
            index = 0
        }
    }
    println(sum)
}