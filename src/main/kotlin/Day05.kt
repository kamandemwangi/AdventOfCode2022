import java.io.File

fun main() {

    val input = File("src/main/resources/Day05.txt").readLines()
    
    val size = 9
    val stack = List(size + 1) { ArrayList<Char>() }
    var i = 0
    while (true) {
        val s = input[i++]
        if (s.startsWith(" 1")) break
        var k = 0
        for (j in 1 until s.length step 4) {
            val ch = s[j]
            k++
            if (ch !in 'A'..'Z') continue
            stack[k].add(0, ch)
        }
    }
    i++
    while (i < input.size) {
        val line = input[i++]
        val regex = Regex("move (\\d+) from (\\d+) to (\\d+)").find(line)!!
        val n = regex.groupValues[1].toInt()
        val from = regex.groupValues[2].toInt()
        val to = regex.groupValues[3].toInt()

        val subList = stack[from].subList(stack[from].size - n, stack[from].size)
        stack[to] += subList
        subList.clear()
    }

    var ans = ""
    for (line in stack) {
        if (line.isEmpty()) continue
        ans += line.last()
    }
    println(ans)
}
