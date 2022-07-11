import java.math.BigInteger

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()
    bw.use { w ->
        val n = readLine().toInt()

        val dp = Array<BigInteger>(1001) { BigInteger("0") }
        dp[1] = BigInteger("1")
        dp[2] = BigInteger("2")

        for(i in 3..1000) {
            dp[i] = dp[i - 1] + (dp[i - 2])
        }

        w.write("${dp[n] % BigInteger("10007")}")
        w.flush()
    }
}

