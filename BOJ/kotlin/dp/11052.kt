import java.lang.Integer.max
import java.util.StringTokenizer

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()

    bw.use { w ->
        val N = readLine().toInt()
        val P = IntArray(N+1)

        val input = StringTokenizer(readLine())
        repeat(N) {
            P[it+1] = input.nextToken().toInt()
        }

        // dp[N] = 카드 N개를 살 수 있는 최대 비용
        // dp[N] = max(P[i] + dp[N-i]) // i개가 들어있는 카드팩을 사고, 나머지 카드 N-i개를 살 수있는 최대 비용
        // 1 <= i <= N
        val dp = IntArray(N+1)

        for(i in 1 .. N) {
            for(j in 1..i) {
                dp[i] = max(dp[i], P[j] + dp[i-j])
            }
        }

        w.write("${dp[N]}")
    }
}

