
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()

    bw.use { w ->
        while(true) {
            val input = readLine()
            if(input == "END") break

            // sol 1
            val result = input.reversed()

            // sol 2
            var res = ""
            for(i in input.length - 1 downTo(0))
                res += input[i].toString()

            w.write("$result\n")
        }
    }
}