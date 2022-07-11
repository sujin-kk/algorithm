import java.util.StringTokenizer

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()
    bw.use { w ->
        val N = readLine().toInt()
        val cost = Array(N){ IntArray(3) }

        repeat(N) {
            val input = StringTokenizer(readLine())
            cost[it][0] = input.nextToken().toInt()
            cost[it][1] = input.nextToken().toInt()
            cost[it][2] = input.nextToken().toInt()
        }

        // 조건 : 인접한 집은 다른 색으로 칠해야 함
        // i 번째 집을 R or G or B 로 칠했을 때
        val dpR = IntArray(N)
        val dpG = IntArray(N)
        val dpB = IntArray(N)
        dpR[0] = cost[0][0]
        dpG[0] = cost[0][1]
        dpB[0] = cost[0][2]

        // 자신보다 한칸 전의 집 색깔을 나머지 두 색중 하나로 칠한 최소 비용을 가져와 더한다.
        for(i in 1 until N) {
            dpR[i] = cost[i][0] + minOf(dpG[i-1], dpB[i-1])
            dpG[i] = cost[i][1] + minOf(dpR[i-1], dpB[i-1])
            dpB[i] = cost[i][2] + minOf(dpR[i-1], dpG[i-1])
        }

        w.write("${minOf(dpR[N-1], dpG[N-1], dpB[N-1])}")
        w.flush()
    }
}

