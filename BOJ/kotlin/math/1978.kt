import java.util.StringTokenizer
import kotlin.math.sqrt

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()

    val N = readLine().toInt()
    val input = StringTokenizer(readLine())

    var result = 0
    for(i in 0 until N) {
        if(prime(input.nextToken().toInt())) {
            result++
        }
    }

    bw.write("$result")
    bw.flush()
    bw.close()
}

fun prime(n: Int): Boolean {
    if(n < 2) {
        return false
    }
    for(i in 2 .. sqrt(n.toDouble()).toInt()) {
        if(n % i == 0) {
            return false
        }
    }
    return true
}
