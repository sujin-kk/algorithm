
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()

    val dp = Array(91){ LongArray(2) }
    // dp[N][L] : N자리 이친수의 개수, 끝자리 L은 0 또는 1
    // dp[N][L] = dp[N-1][0] + dp[N-1][1] : 끝자리가 0인 이친수 + 끝자리가 1인 이친수

    dp[1][1] = 1 // 1
    dp[2][0] = 1 // 10

    bw.use { w ->
        val N = readLine().toInt() // 이친수 길이
        for(n in 3..N) {
            dp[n][0] = dp[n-1][0] + dp[n-1][1]
            dp[n][1] = dp[n-1][0]
        }

        var result:Long = 0
        result += dp[N][0] + dp[N][1]
        w.write("$result")
    }
}


