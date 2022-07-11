
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()
    bw.use { w ->
        val N = readLine().toInt()

        val dp = IntArray(11)

        dp[1] = 1
        dp[2] = 2
        dp[3] = 4
        //1 2 4 7 13 24 44 81 149 274
        for(i in 4..10) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
        }
        repeat(N){
            w.write("${dp[readLine().toInt()]}\n")
        }
        w.flush()
    }
}

