import java.io.File
import java.util.Stack


//This is part one of the solution.
//WARNING This is not the correct solution

fun main() {
    val input = File("src/main/resources/Day07.txt").readLines()
    var root= 0
    var j = 0
    var k = 0
    val stack = Stack<Pair<String, Int>>()
    val map = HashMap<String, Int>()
    val moveIn = Regex("\\$ cd (\\w+)")
    val moveOut = Regex("\\$ cd ..")


    for (line in input) {
        if (moveIn.matches(line)) {
            val res = moveIn.find(line)!!
            val dir = res.groupValues[1]
            stack.push(Pair(dir, 0))
            j++
        }

        if (moveOut.matches(line)) {
            val copy = j
            val popped = stack.pop()
            if (map.containsKey(popped.first)) map[popped.first] = map[popped.first]!! + popped.second
            else map[popped.first] = popped.second
            if (j > 1){
                k += popped.second
                if (copy > j--) map[popped.first] = map[popped.first]!! + k
            } else if (j == 1){
                map[popped.first] = map[popped.first]!! + k
                k = 0
                j = 0
            }
        }

        if (line.startWithAnInt()) {
            val fileSize = line.getInt()
            if (stack.isNotEmpty()) {
                val popped = stack.pop()
                stack.push(Pair(popped.first, popped.second + fileSize))
            }
            root += fileSize
        }
    }
    if (stack.isNotEmpty()) {
        repeat(stack.size) {
            val popped = stack.pop()
            if (map.containsKey(popped.first)) map[popped.first] = map[popped.first]!! + popped.second
            else map[popped.first] = popped.second
        }
    }
    println(map.values.sumOf { if (it <= 100_000) it else 0 })

}


fun String.startWithAnInt(): Boolean {
    val first = this.first()
    return try {
        first.digitToInt()
        true
    } catch (e: java.lang.NumberFormatException) {
        false
    } catch (e: IllegalArgumentException) {
        false
    }
}

fun String.getInt(): Int {
    var i = 0
    var res = ""
    while (this[i] != ' ') {
        res += this[i++]
    }
    return res.toInt()
}
