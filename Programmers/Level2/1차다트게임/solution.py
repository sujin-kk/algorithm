def solution(dartResult):
    answer = 0

    bonus = {'S': 1, 'D': 2, 'T': 3}
    option = {'*': 2, '#': -1}

    number = ''
    scores = []

    for s in dartResult:
        if s.isdigit():
            number += s
        elif s in bonus.keys():
            scores.append(int(number) ** bonus.get(s))
            number = ''
        elif s in option.keys():
            scores[-1] *= option.get(s)
            if s == '*' and len(scores) > 1:
                scores[-2] *= option.get(s)

    answer = sum(scores)

    return answer