def solution(t, p):
    answer = 0
    l = len(p)
    temp = []
    for i in range(len(t)-l+1):
        temp.append(t[i:i+l])
    
    for j in temp:
        if int(j) <= int(p):
            answer += 1
    return answer