fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()
    val N = readLine().toInt() // 단어 개수

    val words: MutableSet<String> = mutableSetOf()

    for(i in 0 until N) {
        val word = readLine()
        words.add(word)
    }

    val result = words.sortedWith(Comparator{ a, b ->
        when {
            a.length < b.length -> -1
            a.length == b.length -> when {
                a < b -> -1
                else -> 1
            }
            else -> 1
        }
    })

    result.map {
        bw.append("$it\n")
    }
    bw.flush()
    bw.close()
}
