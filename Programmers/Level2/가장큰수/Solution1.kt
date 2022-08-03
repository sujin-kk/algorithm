class Solution {
    fun solution(numbers: IntArray): String {
        var answer = ""
        answer =  numbers.sortedWith(Comparator { n1, n2 ->
            "$n2$n1".compareTo("$n1$n2")
        }).joinToString("").run { if(this[0] == '0') "0" else this }

        return answer
    }
}