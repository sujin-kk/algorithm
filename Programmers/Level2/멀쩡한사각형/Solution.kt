class Solution {
    fun solution(w: Int, h: Int): Long {
        var answer: Long = 0

        val longW = w.toLong()
        val longH = h.toLong()

        val gcd = gcd(w.toLong(), h.toLong())

        val minW = w.toLong() / gcd
        val minH = h.toLong() / gcd

        val disable = minW + minH - 1 // 최소 사각형 내에서 대각선의 영향을 받는 정사각형 개수

        answer = (longW * longH) - (disable * gcd)

        return answer
    }

    fun gcd(n: Long, m: Long): Long {
        var a = n
        var b = m

        while(b != 0L) {
            val r = a % b
            a = b
            b = r
        }

        return a
    }
}