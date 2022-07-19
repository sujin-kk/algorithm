import java.util.StringTokenizer

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()
    val mod = 1e9.toLong()

    bw.use { w ->
        val input = StringTokenizer(readLine())
        val N = input.nextToken().toInt()
        val K = input.nextToken().toInt()

        val dp = Array(K + 1) { LongArray( N + 1 )}
        // dp[K][N] : 0~N 까지의 K개 정수를 더해서 N이 되는 경우의 수
        // dp[K][N] = dp[K-1][N-i] : 마지막 수가 i일 때, K-1개를 더해서 N-i가 되는 경우의 수

        for(n in 0 .. N) {
            dp[1][n] = 1
        }

        for(k in 2 .. K) {
            for(n in 0 .. N) { // 0부터 N까지의 합으로 나타내기
                for(i in 0..n) {
                    dp[k][n] += dp[k-1][n-i] % mod
                }
            }
        }

        w.write("${dp[K][N] % mod}")
    }
}


