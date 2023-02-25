import java.io.File

fun main() {
   val input = File("src/main/resources/Day06.txt").readText()
   val set = HashSet<Char>()
   var count = 0


   for (ch in input) {
       if (++count >= 14) {
           var copy = count - 1
           repeat(14) {
               set.add(input[copy--])
           }
           if (set.size == 14) {
               println(count)
               break
           } else set.clear()
       }
   }
}