import java.util.StringTokenizer
import kotlin.math.sqrt

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()

    bw.use { w ->
        val N = readLine().toInt() // 이친수 길이

        val dp = LongArray(N + 1)

        for(i in 1..N) {
            dp[i] = i.toLong()
            for(j in 1 ..sqrt(i.toFloat()).toInt()) {
                if(dp[i] > dp[i - j*j] + 1)
                    dp[i] = dp[i - j*j] + 1
            }
        }

        bw.write("${dp[N]}")
    }
}


