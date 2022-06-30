import java.util.StringTokenizer

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()

    val str = readLine()

    val result = StringTokenizer(str).countTokens()

    bw.write("$result")

    bw.flush()
    bw.close()
}
