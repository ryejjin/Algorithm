def solution(n, m, section):
    answer = 0
    start = section[0]
    answer += 1
    for i in section:
        if start + m > i:
            continue
        start = i
        answer += 1

    return answer