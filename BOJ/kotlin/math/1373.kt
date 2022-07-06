import java.util.Stack
import kotlin.math.pow

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()

    var binary = readLine()

//    var count = 0
//    var result = 0
//    val stack = Stack<Int>()
//    for(i in binary.length - 1 .. 0) {
//        if(count > 3) {
//            stack.push(result)
//            result = 0
//            count = 0
//        }
//
//        result += (Integer.parseInt(binary[i].toString()) * 2.0.pow(count.toDouble())).toInt()
//        count++
//    }

    if (binary.length % 3 == 1) {
        binary = "00$binary"
    }
    if (binary.length % 3 == 2) {
        binary = "0$binary"
    }

    var result = 0
    for (i in binary.indices step 3) {
        result = (binary[i].toString().toInt() * 2.0.pow(2)).toInt() +
                (binary[i+1].toString().toInt() * 2.0.pow(1)).toInt() +
                (binary[i+2].toString().toInt() * 2.0.pow(0)).toInt()
        sb.append("$result")
    }

    bw.write("$sb")
    bw.flush()
    bw.close()
}
