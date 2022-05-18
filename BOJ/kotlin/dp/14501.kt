import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {

    val N = nextInt()
    val schedules = arrayListOf<Pair<Int, Int>>()
    val income = IntArray(N+1) { 0 }
    println(income.size)

    for(i in 0 until N) {
        schedules.add(Pair(nextInt(), nextInt()))
    }

    // Key : 오늘이 i일 일때,
    // income[i]를 i-1일까지 일했을 때 얻을 수 있는 최대 수입이라고 하면
    // income[i] = max(income[i], income[i-1]) 식 성립
    // i번째 날에 일을 할수도, 안할수도 있으므로
    // income[i + T[i]] = max(income[i + T[i]], income[i] + P[i]) 식 성립
    for(i in 0 until N) {
        if(i >= 1) {
            income[i] = income[i].coerceAtLeast(income[i - 1])
        }

        val day = i + schedules[i].first
        if(day in 1..N) {
            income[day] = income[day].coerceAtLeast((income[i] + schedules[i].second))
        }
    }
    print(income[N - 1].coerceAtLeast(income[N]))

}

