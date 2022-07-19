import java.util.StringTokenizer

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()

    // dp[i] = 마지막 수가 i인 가장 큰 연속 합
    // dp[i] = a[i] + dp[i-1]
    bw.use { w ->
        val N = readLine().toInt() // 이친수 길이

        val a = IntArray(N)
        val dp = IntArray(N)

        val input = StringTokenizer(readLine())
        for(i in 0 until N) {
            a[i] = input.nextToken().toInt()
            dp[i] = a[i]
        }

        for(i in 1 until N) {
            dp[i] = maxOf(dp[i-1] + a[i], a[i])
        }

        w.write("${dp.maxOrNull()}")
    }
}


