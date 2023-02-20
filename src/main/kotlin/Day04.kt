import java.io.File

fun main() {
    part01()
}

fun part01() {
    val input = File("src/main/resources/Day04.txt").readLines()

    var count = 0
    for (line in input) {
        val pair = line.split(",")
        val (a, b) = pair[0].split("-")
        val (c, d) = pair[1].split("-")

        if ((a.toInt() >= c.toInt()) && b.toInt() <= d.toInt()) count++
        else if ((c.toInt() >= a.toInt()) && d.toInt() <= b.toInt()) count++
    }
    println(count)
}