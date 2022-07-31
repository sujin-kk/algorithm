import kotlin.math.ceil

class Solution2 {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()

        val durations = mutableListOf<Int>()
        val max = 100

        for (i in progresses.indices) {
            durations.add(ceil((max - progresses[i]) / speeds[i].toDouble()).toInt())
        }

        var count = 1
        var standard = durations[0]

        for (i in 1 until durations.size) {
            if(standard < durations[i]) {
                answer = answer.plus(count)
                standard = durations[i]
                count = 1
            }
            else {
                count++
            }
        }

        answer = answer.plus(count)

        return answer

    }
}