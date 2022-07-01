import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()

    val str = readLine() // 초기 문자열
    val N = readLine().toInt() // 명령어 개수

    val left = Stack<String>()
    val right = Stack<String>()

    // 초기 : 모두 커서의 왼쪽
    str.map {
        left.push(it.toString())
    }

    for(i in 0 until N) {
        val cmd = readLine()
        val tokens = StringTokenizer(cmd)
        when (tokens.nextToken()) {
            "L" -> {
                if(left.isNotEmpty()) {
                    right.push(left.pop())
                }
            }
            "D" -> {
                if(right.isNotEmpty()) {
                    left.push(right.pop())
                }
            }
            "B" -> {
                if(left.isNotEmpty()) {
                    left.pop()
                }
            }
            "P" -> {
                left.push(tokens.nextToken())
            }
        }
    }

    while(left.isNotEmpty()) {
        right.push(left.pop())
    }

    while(right.isNotEmpty()) {
        sb.append(right.pop())
    }

    bw.write("$sb")
    bw.flush()
    bw.close()
}
