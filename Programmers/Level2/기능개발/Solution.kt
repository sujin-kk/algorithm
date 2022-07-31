import kotlin.math.ceil
import java.util.*

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()
        val queue: Queue<Int> = LinkedList<Int>()
        val max = 100

        // 일수 계산
        for (i in progresses.indices) {
            queue.add(ceil((max - progresses[i]) / speeds[i].toDouble()).toInt())
        }

        while(queue.isNotEmpty()) {
            var count = 1
            val standard = queue.poll() // 맨 앞의 값 = 기준이 되는 일수
            while(queue.isNotEmpty() && standard >= queue.peek()) {
                queue.remove()
                count++
            }
            answer = answer.plus(count)
        }

        return answer

    }
}