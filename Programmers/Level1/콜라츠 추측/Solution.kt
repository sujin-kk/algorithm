class Solution {
    fun solution(num: Int): Int {
        var answer = 0
        var temp:Long = num.toLong()

        while(temp != 1L) {

            if(answer > 500)
                return -1

            if(temp % 2 == 0L) {
                temp /= 2
            }
            else {
                temp = temp * 3 + 1
            }
            answer++
        }
        return answer
    }
}
