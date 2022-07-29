class Solution {
    fun solution(s: String): Int {
        var min = s.length

        for (i in 1..s.length / 2) {
            var tempStr = ""
            var repeatStr = ""
            var nextStr = ""
            var count = 1
            var isLast = false

            for(j in s.indices step(i)) {
                repeatStr = s.substring(j, j+i)

                // 반복자 다음 인덱스부터 비교
                if(j + 2 * i <= s.length)
                    nextStr = s.substring(j + i, j + 2 * i)
                else {
                    nextStr = s.substring(j + i) // 남은거 끝까지
                    isLast = true
                }

                if(repeatStr == nextStr) {
                    count++
                }
                else {
                    if(isLast) {
                        tempStr += if(count != 1) {
                            "$count$repeatStr$nextStr"
                        } else {
                            (repeatStr + nextStr)
                        }
                        break
                    }
                    tempStr += if(count != 1) {
                        "$count$repeatStr"
                    } else {
                        repeatStr
                    }
                    count = 1
                }
            }
            min = minOf(min, tempStr.length)
        }

        return min
    }
}
