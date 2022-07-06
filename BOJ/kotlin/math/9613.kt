import java.util.StringTokenizer

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()

    val t = readLine().toInt()
    for (i in 0 until t) {
        val input = StringTokenizer(readLine())

        val n = input.nextToken().toInt() // 4
        val arr = IntArray(n) { -1 } // 10 20 30 40

        for(j in 0 until n) {
            arr[j] = input.nextToken().toInt()
        }

        var result:Long = 0 // 답이 Int의 범위를 넘어갈 수 있으므로 Long으로 선언
        for(a in 0 until n - 1) {
            for (b in a + 1 until n) {
                result += GCD(arr[a], arr[b])
            }
        }

        sb.append("$result\n")
    }

    bw.write("$sb")
    bw.flush()
    bw.close()
}

fun GCD(n: Int, m: Int): Int {
    var a = n
    var b = m

    while(b != 0) {
        val r = a % b
        a = b
        b = r
    }

    return a
}
