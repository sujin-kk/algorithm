
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()
    val mod = 9901
    val N: Int = readLine().toInt() // 1 .. 100,000

    // dp[i][0] : i번째 줄에 아무것도 배치 x , dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2]
    // dp[i][1] : i번째 줄 1번째에 사자 배치 , dp[i][1] = dp[i-1][0] + dp[i-1][2]
    // dp[i][2] : i번째 줄 2번째에 사자 배치 , dp[i][2] = dp[i-1][0] + dp[i-1][1]
    val dp: Array<IntArray> = Array(N + 1) { IntArray(3) }
    dp[1][0] = 1
    dp[1][1] = 1
    dp[1][2] = 1

    bw.use { w ->
        for(i in 2 .. N) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % mod
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % mod
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % mod
        }
        bw.write("${(dp[N][0] + dp[N][1] + dp[N][2]) % mod}")
    }
}