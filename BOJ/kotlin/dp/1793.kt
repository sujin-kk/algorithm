import java.math.BigInteger

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val D = Array<BigInteger>(251) { BigInteger("0") }

    while(true) {
        try {
            val line = readLine()
            val n = line.toInt()

            D[0] = BigInteger("1")
            D[1] = BigInteger("1")

            for(i in 2..n) {
                D[i] = D[i-1] + D[i-2].multiply(BigInteger("2"))
            }

            println(D[n])

        } catch (e: NumberFormatException) { break }
        catch (e: NullPointerException) { break }
    }


}
