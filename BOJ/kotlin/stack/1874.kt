import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()
    val N = readLine().toInt()
    val stack = Stack<Int>()

    var cur = 1 // stack에 들어는 수 (입력값까지 증가)

    for (i in 0 until N) {
        val num = readLine().toInt()
        while(cur <= num) { // cur:입력값까지 push
            stack.push(cur)
            sb.append("+\n")
            cur += 1
        }
        if(num == stack.last()) { // 입력 값이 cur보다 작을때 최상단==입력 -> pop 해서 빼내기
            stack.pop()
            sb.append("-\n")
        }
        else { // 최상단 != 입력 -> NO
            println("NO")
            return
        }
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
}
