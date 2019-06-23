
def printVertical(num):
    if (num == 0):
        return

    printVertical (num / 10)
    print (num % 10)


num = input("Enter a number")
printVertical(num)
