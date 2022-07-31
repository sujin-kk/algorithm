import java.util.*

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0

        data class Document(val priority: Int, val isTarget: Boolean)
        val queue:Queue<Document> = LinkedList<Document>()

        for(i in priorities.indices) {
            if(i == location)
                queue.add(Document(priorities[i], true))
            else
                queue.add(Document(priorities[i], false))
        }

        var first: Document
        while(queue.isNotEmpty()) {
            first = queue.poll()
            if(queue.any { first.priority < it.priority }) {
                queue.add(first)
            }
            else {
                answer++
                if(first.isTarget)
                    break
            }
        }
        return answer
    }
}