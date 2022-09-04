
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()
    val max = 100

    val talls = mutableListOf<Int>()

    bw.use { w ->
        repeat(9) {
            talls.add(readLine().toInt())
        }

        // sol 1. sum에서 2명의 키를 빼기
        val sum = talls.sum() // 9명 키의 총 합

        for(i in talls.indices) {
            for(j in talls.indices) {
                if(i != j && (sum - (talls[i] + talls[j])) == max) {
                    val fir = talls[i]
                    val sec = talls[j]

                    talls.remove(fir)
                    talls.remove(sec)

                    talls.sort()
                    talls.forEach {
                        w.write("$it\n")
                    }
                    return
                }
            }
        }

    }
}


