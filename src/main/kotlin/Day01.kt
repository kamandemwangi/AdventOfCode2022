import java.io.File

fun main() {
}

fun part1() {
    val input = File("src/main/resources/Day01.txt").readText().split("\n")
    var max = 0
    var temp = 0


    for (i in input) {
        if (i.isNotBlank()) temp += i.toInt()
        else{
            max = Math.max(max, temp)
            temp = 0
        }
    }
}

fun part2() {
    val input = File("src/main/resources/Day01.txt").readText().split("\n")
    var first = 0
    var second = 0
    var third = 0
    var temp = 0


    for (i in input) {
        if (i.isNotBlank()) temp += i.toInt()
        else{
            first = Math.max(first, temp)
            temp = 0
        }
    }


    for (i in input) {
        if (i.isNotBlank()) temp += i.toInt()
        else{
            if (temp != first){
                second = Math.max(second, temp)
            }
            temp = 0
        }
    }

    for (i in input) {
        if (i.isNotBlank()) temp += i.toInt()
        else{
            if (temp != first && temp != second) {
                third = Math.max(third, temp)
            }
            temp = 0
        }
    }
    val sum = first + second + third

    //runs in O(n + n + n) => O(n) time and O(1) space complexity
}