class Solution {
    fun solution(numbers: IntArray): String {
        var answer = ""
        val sb = StringBuilder()

        val strs = numbers.map {
            it.toString()
        }

        strs.sortedWith { a, b ->
            when (a.length) {
                b.length -> b.compareTo(a)
                else -> (b+a).compareTo(a+b)
            }
        }.forEach {
            sb.append(it)
        }

        answer = if(sb.toString()[0] == '0') "0" else sb.toString()

        return answer
    }
}