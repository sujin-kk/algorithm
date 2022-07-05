import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()

    val N = readLine().toInt() // size of A

    val A = IntArray(N) { 0 }
    val NGE = IntArray(N) { 0 }
    val stack = Stack<Int>()

    val input = StringTokenizer(readLine())

    for(i in 0 until N) {
        A[i] = input.nextToken().toInt()
    }

    A.mapIndexed { idx, it ->
        // stack이 비어있지 않고 오큰수를 찾아내면 -> 왼쪽에 있는 값들의 오큰수를 업데이트
        while(stack.isNotEmpty() && it > A[stack.peek()]) {
            NGE[stack.peek()] = it
            stack.pop()
        }
        stack.push(idx)
    }

    while(stack.isNotEmpty()) {
        NGE[stack.peek()] = -1
        stack.pop()
    }

    NGE.mapIndexed { idx, it ->
        if(idx == NGE.size - 1) {
            sb.append("$it")
        }
        else {
            sb.append("$it ")
        }
    }

    bw.write("$sb")
    bw.flush()
    bw.close()
}
