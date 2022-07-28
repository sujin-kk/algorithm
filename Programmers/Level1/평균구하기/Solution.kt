class Solution {
    fun solution(arr: IntArray): Double {
        // sol 1
        var answer: Double = 0.0
        arr.map { num ->
            answer += num
        }
        answer /= arr.size
        return answer

        // sol 2
        // return arr.average()
    }
}