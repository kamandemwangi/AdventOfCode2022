import java.io.File

fun main() {
    val input = File("src/main/resources/Day04.txt").readLines()
    //part01(input)
    part02(input)
}

fun part01(input: List<String>) {
    var count = 0
    for (line in input) {
        val pair = line.split(",")
        val (a, b) = pair[0].split("-").map { it.toInt() }
        val (c, d) = pair[1].split("-").map { it.toInt() }

        if ((a >= c) && b <= d) count++
        else if ((c >= a) && d <= b) count++
    }
    println(count)
}

fun part02(input: List<String>) {
    var count = 0

    for (line in input) {
        val pair = line.split(",")
        val (a, b) = pair[0].split("-").map { it.toInt() }
        val (c, d) = pair[1].split("-").map { it.toInt() }

        if(a in c..d || b in c..d) count++
        else if(c in a..b || d in a..b) count++
    }

    println(count)
}