import java.util.StringTokenizer

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()

    val str = readLine().uppercase()
    val map = HashMap<Char, Int>()
    str.map {
        if(map.containsKey(it)) {
            map.replace(it, map[it]!!.plus(1))
        }
        else {
            map[it] = 1
        }
    }

    val max = map.maxByOrNull { it.value }

    if(map.filter { it.value == max!!.value }.count() > 1) {
        bw.write("?")
    }
    else {
        bw.write("${max!!.key}")
    }

    bw.flush()
    bw.close()
}
