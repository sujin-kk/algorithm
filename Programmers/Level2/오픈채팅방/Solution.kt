class Solution {
    fun solution(record: Array<String>): Array<String> {
        var answer = arrayOf<String>()
        var resultRecord = arrayOf<String>()

        val state = object {
            val ENTER = "Enter"
            val LEAVE = "Leave"
            val CHANGE = "Change"
        }

        val map = hashMapOf<String, String>()

        record.map {
            val str = it.split(" ")
            when(str[0]) {
                state.ENTER -> {
                    if(map.containsKey(str[1])) {
                        map.replace(str[1], str[2])
                    }
                    else {
                        map[str[1]] = str[2]
                    }
                    resultRecord = resultRecord.plus(it)
                }
                state.LEAVE -> {
                    resultRecord = resultRecord.plus(it)
                }
                state.CHANGE -> {
                    map.replace(str[1], str[2])
                }
                else -> {}
            }
        }

        resultRecord.map {
            val str = it.split(" ")
            val enterStr = String.format("%s님이 들어왔습니다.", map[str[1]])
            val leaveStr = String.format("%s님이 나갔습니다.", map[str[1]])
            when(str[0]) {
                state.ENTER -> {
                    answer = answer.plus(enterStr)
                }
                state.LEAVE -> {
                    answer = answer.plus(leaveStr)
                }
                else -> {}
            }
        }

        return answer
    }
}