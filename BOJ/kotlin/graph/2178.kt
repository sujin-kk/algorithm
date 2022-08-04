import com.sun.org.apache.xpath.internal.operations.Bool
import java.util.*

var graph = arrayOf<IntArray>()
var visited = arrayOf<BooleanArray>()

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()

    // n,m 으로 이동할 때 지나야 하는 최소 칸 수
    val (n, m) = readLine().split(" ").map { it.toInt() }

    graph = Array(n) { IntArray(m) }
    visited = Array(n) { BooleanArray(m) }

    repeat(n) { i ->
        val row = readLine()
        repeat(m) { j ->
            graph[i][j] = row[j] - '0'
            visited[i][j] = false
        }
    }

    bfs()
    bw.use {
        it.write("${graph[n - 1][m - 1]}")
    }
}

fun bfs() {
    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)
    val q: Queue<Pair<Int, Int>> = LinkedList()

    q.add(Pair(0, 0))
    visited[0][0] = true

    while(q.isNotEmpty()) {
        val target = q.poll()
        for(i in 0 until 4) {
            val nx = target.first + dx[i]
            val ny = target.second + dy[i]
            if (nx in graph.indices && ny in graph[0].indices) {
                if(graph[nx][ny] == 1 && !visited[nx][ny]) {
                    q.add(Pair(nx, ny))
                    graph[nx][ny] = graph[target.first][target.second] + 1
                    visited[nx][ny]
                }
            }
        }
    }
}
