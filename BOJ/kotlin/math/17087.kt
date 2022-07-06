import java.util.StringTokenizer
import kotlin.math.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()

    val input1 = StringTokenizer(readLine())
    val N = input1.nextToken().toInt() // 동생 수
    val S = input1.nextToken().toInt() // 현재 위치

    val input2 = StringTokenizer(readLine())
    val A = IntArray(N) { -1 } // 동생 위치

    for(i in 0 until N) {
        if(input2.hasMoreTokens()) {
            A[i] = input2.nextToken().toInt()
        }
    }

    val distance = IntArray(N) { -1 }
    A.mapIndexed { idx, it ->
        distance[idx] = abs(S - it)
    }

    // distance GCD
    var result = distance[0]
    for(d in distance) {
        result = GCD(d, result)
    }

    bw.write("$result")
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
