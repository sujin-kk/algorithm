import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()

    val stack = Stack<Char>()
    var isTag = false
    val str = readLine() // 초기 문자열 <tag>hi bye<tag>

    str.map {
        if(it == '<') {
            while(stack.isNotEmpty()) {
                sb.append(stack.pop())
            }
            isTag = true
            sb.append(it)
        }
        else if(it == '>') {
            isTag = false
            sb.append(it)
        }
        else if(isTag) {
            sb.append(it)
        }
        else {
            if(it == ' ') {
                while(stack.isNotEmpty()) {
                    sb.append(stack.pop())
                }
                sb.append(it)
            }
            else {
                stack.push(it)
            }
        }
    }
    while(stack.isNotEmpty()) {
        sb.append(stack.pop())
    }

    bw.write("$sb")
    bw.flush()
    bw.close()
}
