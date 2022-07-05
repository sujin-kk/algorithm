import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()

    val str = readLine() // 괄호 표현
    var result = 0 // 쇠막대기 총 개수

    // sol 1 - stack
    val stack = Stack<Int>() // 쇠막대기 index

    str.mapIndexed { idx, it ->
        when(it) {
            '(' -> {
                stack.push(idx)
            }
            ')' -> {
                if(idx - stack.peek() == 1)  {
                    // 레이저
                    stack.pop() // 레이저 제거
                    result += stack.size
                }
                else {
                    // 쇠막대기를 자르기
                    stack.pop() // 쇠막대기의 끝
                    result += 1
                }
            }
            else -> result += 0
        }
    }

    // sol 2
    var prev = ' '
    var lastIndex = 0
    for(s in str) when (s) {
        '(' -> {
            lastIndex++
            prev = '('
        }

        ')' -> {
            lastIndex--
            if(prev == '(') {
                // 레이저
                result += lastIndex
            }
            else {
                // 쇠막대기 자르기
                result += 1
            }
            prev = ')'
        }
    }

    bw.write("$result")
    bw.flush()
    bw.close()
}
