strNums = input("Enter numbers (split by ;): ")
arrNums = strNums.split(';')
for strNum in arrNums:
    if strNum == "zero":
        print("0", end="")
    elif strNum == "one":
        print("1", end="")
    elif strNum == "two":
        print("2", end="")
    elif strNum == "three":
        print("3", end="")
    elif strNum == "four":
        print("4", end="")
    elif strNum == "five":
        print("5", end="")
    elif strNum == "six":
        print("6", end="")
    elif strNum == "seven":
        print("7", end="")
    elif strNum == "eight":
        print("8", end="")
    elif strNum == "nine":
        print("9", end="")
