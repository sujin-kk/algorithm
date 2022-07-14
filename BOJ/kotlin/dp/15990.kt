
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()
    val mod = 1e9.toLong() + 9 // 100,000,009
    bw.use { w ->
        val T = readLine().toInt()
        val dp = Array(100001) { LongArray(4) } // ovf 방지 위해 long type
        // dp[i][j] = i를 1,2,3 합으로 나타내는 수, 맨 마지막 수는 j
        // dp[i][1] = dp[i-1][2] + dp[i-1][3]

        dp[1][1] = 1
        dp[2][2] = 1
        dp[3][3] = 1
        dp[3][1] = 1
        dp[3][2] = 1

        for(i in 4..100000) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % mod
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % mod
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % mod
        }

        repeat(T) {
            val n = readLine().toInt()
            sb.append("${(dp[n][1] + dp[n][2] + dp[n][3]) % mod}\n")
        }

        w.write("$sb")
    }
}


