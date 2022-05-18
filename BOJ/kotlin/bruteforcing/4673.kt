fun main(args: Array<String>) {

    val sb = StringBuilder()
    val isSelf = BooleanArray(10001) { true } // 1..10000

    // Key : 1-10000 중 해당 수를 생성자로 하는 n을 거르면 된다.
    for(i in 1..10000) {
        val n = d(i) // i를 생성자로 가지는 n
        if(n < 10001) { // d(1) = 1 d(2) = 2 d(3) = 3
            isSelf[n] = false // 생성자가 존재하는 n 거르기
        }
    }

    for(i in 1..10000) {
        if(isSelf[i])
            sb.append(i).append('\n')
    }

    print(sb)
}

// n을 생성자로 하는 수 리턴,d(75) = 75+7+5 = 87 리턴
fun d(n: Int): Int {
    var num = n
    var sum = n
    while(num > 0) {
        sum += num % 10
        num /= 10
    }
    return sum
}