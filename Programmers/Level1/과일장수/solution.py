def solution(k, m, score):
    answer = 0
    score.sort(reverse=True)
    boxes = []

    for i in range(len(score)):
        boxes.append(score[i])
        if (i + 1) % m == 0:
            answer += min(boxes) * m
            boxes = []

    return answer