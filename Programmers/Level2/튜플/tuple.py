def solution(s):
    answer = []

    s = s[2:-2]
    sets = s.split("},{")
    sets.sort(key=len)

    for set in sets:
        setArr = set.split(',')
        for number in setArr:
            if number not in answer:
                answer.append(number)

    #   시간 초과
    #     sets = []
    #     for i in range(len(s) - 1):
    #         for j in range(i + 1, len(s)):
    #             if s[i] == '{':
    #                 if s[j] == '{':
    #                     break
    #                 if s[j] == '}':
    #                     numbers = s[i + 1:j].split(',')
    #                     sets.append(numbers)
    #                     break
    #     sets.sort(key=lambda x: len(x))

    #     for set in sets:
    #         for number in set:
    #             if number not in answer:
    #                 answer.append(number)

    return list(map(int, answer))
