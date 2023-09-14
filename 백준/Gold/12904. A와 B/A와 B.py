s = input()
t = input()

while t != s:
    if len(t) == 0:
        print('0')
        exit()
    if t[-1] == 'A':
        t = t[:-1]
    elif t[-1] == 'B':
        t=t[::-1]
        t=t[1:]
    else:
        print('0')
        exit()
print('1')