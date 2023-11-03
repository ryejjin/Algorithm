def solution(n, build_frame):
    def is_valid_structure(x, y, a, result):
        if a == 0: # 보
            if y == 0 or [x, y-1, 0] in result or [x, y, 1] in result or [x-1, y, 1] in result:
                return True
        else: # 기둥
            if [x, y-1, 0] in result or [x+1, y-1, 0] in result or ([x-1, y, 1] in result and [x+1, y, 1] in result):
                return True
        return False

    result = []
    for x, y, a, b in build_frame:
        if b == 1: # 건물 생성
            if is_valid_structure(x, y, a, result):
                result.append([x, y, a])
        else: # 건물 제거
            result.remove([x, y, a])
            for i in result:
                xpos, ypos, stru = i
                if not is_valid_structure(xpos, ypos, stru, result):
                    result.append([x, y, a])
                    break

    answer = sorted(result)
    return answer