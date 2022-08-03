import java.util.LinkedList
import java.util.Queue

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()

    val N = readLine().toInt()
    val a = Array(N) { IntArray(N) }
    val d = Array(N) { IntArray(N) } // 방문 안했으면 0, 했으면 단지 번호

    repeat(N) { i ->
        val row = readLine()
        repeat(N) { j ->
            a[i][j] = row[j] - '0'
        }
    }

    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)
    var cnt = 0
    var totalCnt = 0
    val blockCnt = arrayListOf<Int>()
    for(x in a.indices) {
        for(y in a[0].indices) {
            if(a[x][y] == 1 && d[x][y] == 0) { // 단지에 속해있는데, 아직 방문 안했으면
                val q : Queue<Pair<Int, Int>> = LinkedList()
                q.add(Pair(x, y))
                d[x][y] = ++cnt
                var curBlockCnt = 1

                while(q.isNotEmpty()) {
                    val target = q.poll()

                    for(k in 0 until 4) { // 상 하 좌 우
                        val nx = target.first + dx[k]
                        val ny = target.second + dy[k]

                        if(nx in a.indices && ny in a.indices) {
                            if(a[nx][ny] == 1 && d[nx][ny] == 0) {
                                q.add(Pair(nx, ny))
                                d[nx][ny] = cnt
                                curBlockCnt++
                            }
                        }
                    }
                }

                totalCnt++
                blockCnt.add(curBlockCnt)
            }
        }
    }

    bw.use {
        sb.append("$totalCnt\n")
        blockCnt.sorted().forEach {
            sb.append("$it\n")
        }
        it.write(sb.toString())
    }

}

