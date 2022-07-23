
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()

    bw.use { w ->
        val s1 = readLine()
        val s2 = readLine()

        if(s1.equals(s2))
            w.write("24:00:00") // 최대 24시간을 기다리는 경우

        else {
            val curTime = s1.split(":").map { it.toInt() }
            val throwTime = s2.split(":").map { it.toInt() }

            var h = throwTime[0] - curTime[0]
            var m = throwTime[1] - curTime[1]
            var s = throwTime[2] - curTime[2]

            if(s < 0) {
                s += 60
                m--
            }

            if(m < 0) {
                m += 60
                h--
            }

            if(h < 0) {
                h += 24
            }

            w.write(String.format("%02d:%02d:%02d", h, m, s))
        }
    }
}