
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()
    val mod = 1e9.toLong() // 1,000,000,000

    val dp = Array(101){ LongArray(10) }
    // dp[N][L] : 길이가 N인 계단수, 마지막 수는 L
    // dp[N][L] = dp[N-1][L-1] + dp[N-1][L+1]
    // L이 0 또는 9라면?

    for (i in 1..9) {
        dp[1][i] = 1
    }

    bw.use { w ->
        val N = readLine().toInt() // 계단 수 길이

        for (n in 2..N) {
            for(l in 0..9) {
                if(l-1 < 0) dp[n][l] += dp[n-1][l+1]

                else if(l+1 > 9) dp[n][l] += dp[n-1][l-1]

                else dp[n][l] += dp[n-1][l-1] + dp[n-1][l+1]

                dp[n][l] %= mod
            }
        }

        var result: Long = 0
        dp[N].map {
            result += it
        }

        w.write("${result % mod}")
    }
}


