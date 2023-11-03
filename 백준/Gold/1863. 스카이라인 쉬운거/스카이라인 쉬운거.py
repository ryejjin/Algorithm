n = int(input())
stack = []
ans = 0

for i in range(n):
    x, high = map(int, input().split())
    if stack:
        if stack[-1] < high:
            stack.append(high)
        elif stack[-1] > high:
            while stack and stack[-1]>high:
                stack.pop()
                ans += 1
            if not stack:
                if high > 0:
                    stack.append(high)
            else:
                if stack[-1] < high:
                    stack.append(high)
    else:
        if high > 0:
            stack.append(high)

print(ans+len(stack))