
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()

    val mod = 10007
    val N: Int = readLine().toInt() // 1 .. 1,000 : 길이

    // dp[i][j] : 길이가 i고, 마지막 숫자가 j인 오르막 수의 개수
    val dp: Array<IntArray> = Array(N + 1) { IntArray(10) }
    repeat(10) {
        dp[1][it] = 1
    }

    bw.use { w ->
        for(i in 2..N) {
            for(j in 0 .. 9) {
                for(k in 0 .. j)
                    dp[i][j] += dp[i-1][j-k] % mod
            }
        }

        var result = 0
        repeat(10) {
            result += dp[N][it]
        }
        bw.write("${result % mod}")
    }
}