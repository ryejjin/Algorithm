vowel = ['a', 'e', 'i', 'o', 'u']
while True:
    text = input()
    if text == 'end':
        break
    con = 0
    vow = 0
    vow_c = 0
    err = 0
    m = len(text)
    for i in range(m):
        if i > 0:
            if text[i] == text[i-1]:
                if text[i] != 'e' and text[i] !='o':
                    err = 1
                    break
        if text[i] in vowel:
            vow += 1
            vow_c += 1
            con = 0
            if vow_c == 3:
                err = 1
                break
        else:
            con += 1
            vow_c = 0
            if con == 3:
                err = 1
                break

    if err!=1 and vow > 0:
        print(f'<{text}> is acceptable.')
    else:
        print(f'<{text}> is not acceptable.')