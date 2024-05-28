def solution(str1, str2):
    answer = 0

    def listOf(s: str, digit: int):
        elements = []
        for i in range(0, (len(s) - (digit - 1))):
            cur = s[i:i + digit]
            if all(ch.isalpha() for ch in cur):
                elements.append(cur.lower())
        return elements

    def intersection(l1, l2):
        temp = l1.copy()
        elements = []
        for x in l2:
            if x in temp:
                temp.remove(x)
                elements.append(x)
        return elements

    def union(l1, l2):
        temp = l1.copy()
        elements = l1.copy()
        for x in l2:
            if x in temp:
                temp.remove(x)
            else:
                elements.append(x)
        return elements

    def getJacquard(str1: str, str2: str, digit: int, fixed: int):
        l1 = listOf(str1, digit)
        l2 = listOf(str2, digit)

        if len(l1) == 0 and len(l2) == 0:
            return 1 * fixed

        return int((len(intersection(l1, l2)) / len(union(l1, l2))) * fixed)

    answer = getJacquard(str1, str2, 2, 65536)

    return answer