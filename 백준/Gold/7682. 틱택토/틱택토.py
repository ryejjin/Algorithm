def check_win(tic, player):
    win = False
    if  player == tic[0] == tic[1] == tic[2]\
            or player == tic[3] == tic[4] == tic[5]\
            or player == tic[6] == tic[7] == tic[8]\
            or player == tic[0] == tic[3] == tic[6]\
            or player == tic[1] == tic[4] == tic[7]\
            or player == tic[2] == tic[5] == tic[8]\
            or player == tic[0] == tic[4] == tic[8]\
            or player == tic[2] == tic[4] == tic[6]:
        win = True
    return win

def check(tic):
    winX, winO = check_win(tic, "X"), check_win(tic, "O")
    x, o, dot = tic.count("X"), tic.count("O"), tic.count(".")
    if (winX and not winO and x == o+1)\
        or (not winX and winO and x==o)\
        or (not winX  and not winO and x == 5 and o ==4):
        return "valid"
    return "invalid"

while True:
    tic = input()
    if tic == "end":
        break
    print(check(tic))