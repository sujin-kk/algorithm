fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()
    val N = readLine().toInt() // 단어 개수

    var result:Int = 0

    for(i in 0 until N) {
        val str = readLine()
        var switchNum:Int = 0
        val chars = arrayListOf<Char>()
        str.mapIndexed { idx, ch ->
            if(!chars.contains(ch)) {
                chars.add(ch)
            }
            if(idx > 0) {
                if(str[idx-1] != str[idx]) {
                    switchNum++
                }
            }
        }
        if(switchNum == chars.size - 1) {
            result++
        }
    }
    bw.write("$result")
    bw.flush()
    bw.close()
}