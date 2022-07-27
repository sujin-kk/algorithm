
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()

    val max = 1e6.toInt()
    val T = readLine().toInt() // test case num

    // 각 테스트 케이스마다 소수 판별을 하면 시간 초과
    // 미리 소수 구하기
    val isNotPrime = BooleanArray(size = max + 1) { false }

    // Sieve of Eratosthenes 이용
    for(i in 2 .. max) {
        if(!isNotPrime[i]) {
            // i*i 는 범위 초과
            // 5 -> 10 15 20 ...
            for(j in i*2 .. max step(i)) {
                isNotPrime[j] = true // 지워지면 소수가 아니다.
            }
        }
    }

    bw.use { w ->
        repeat(T) {
            val N = readLine().toInt()
            var result = 0
            for(a in 2 .. N/2) {
                if(!isNotPrime[a] && !isNotPrime[N-a])
                    result++
            }
            sb.append("$result\n")
        }
        w.write(sb.toString())
    }
}