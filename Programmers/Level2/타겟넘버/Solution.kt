class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        val max = numbers.size

        fun dfs(index: Int, result: Int) {
            if(index == max) {
                if(result == target)
                    answer++
            }
            else {
                dfs(index+1, result + numbers[index])
                dfs(index+1, result - numbers[index])
            }
        }

        dfs(0, 0)
        return answer
    }
}