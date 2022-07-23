
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()

    bw.use { w ->
        val N = readLine().toInt()
        val numbers = readLine()
        var result = 0

        numbers.map {
            result += it.toString().toInt()
        }
        w.write("$result")
    }
}