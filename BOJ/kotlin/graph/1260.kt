import java.util.*

var graph = arrayOf<IntArray>()
var visited = booleanArrayOf()
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()

    val (n, m, v) = readLine().split(" ").map { it.toInt() }

    graph = Array(n) { IntArray(n) }
    visited = BooleanArray(n)

    repeat(m) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        graph[x-1][y-1] = 1
        graph[y-1][x-1] = 1
    }

    visited.fill(false)
    dfs(v-1, n)
    println("")
    visited.fill(false)
    bfs(v-1, n)
}

fun dfs(x: Int, n: Int) {
    visited[x] = true
    print("${x+1} ")
    for(i in 0 until n) {
        if(graph[x][i] == 1 && !visited[i]) {
            dfs(i, n)
        }
    }
}

fun bfs(x: Int, n: Int) {
    val q: Queue<Int> = LinkedList()
    visited[x] = true
    q.add(x)
    print("${x+1} ")

    while(q.isNotEmpty()) {
        val target = q.poll()
        for(i in 0 until n) {
            if(graph[target][i] == 1 && !visited[i]) {
                visited[i] = true
                q.add(i)
                print("${i+1} ")
            }
        }
    }
}
