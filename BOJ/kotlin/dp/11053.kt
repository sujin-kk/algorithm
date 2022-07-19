import java.util.StringTokenizer

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()

    // dp[i] = 마지막 수가 i일 때 가장 긴 증가 수열의 개수
    // dp[i] = max(dp[j]) + 1 : j는 i 앞에 있는 수, j < i && a[j] < a[i]
    bw.use { w ->
        val N = readLine().toInt() // 이친수 길이

        val a = IntArray(N)
        val dp = IntArray(N) { 1 }

        val input = StringTokenizer(readLine())
        for(i in 0 until N) {
            a[i] = input.nextToken().toInt()
        }

        for(i in 1 until N) {
            for(j in 0 until i) {
                if(a[j] < a[i] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1
            }
        }

        w.write("${dp.maxOrNull()}")
    }
}


