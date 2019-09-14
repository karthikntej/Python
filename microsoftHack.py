
def isPrime(num):
    if num > 1:
        for i in range(2,num):
            if (num % i) == 0:
                return 0
        else:
            return 1
    else:
        return 0

def traverse(i, j, q):
    #print "Recurssion....................",i ,j
    if (i-1 < m and i-1 >= 0 and b[i-1][j] == q):
        b[i-1][j] = y
        traverse(i-1, j, q)
    if (j-1 < n and j-1>= 0 and b[i][j-1] == q):
        b[i][j-1] = y
        traverse(i, j-1, q)
    if (i+1 < m and b[i+1][j] == q):
        b[i+1][j] = y
        traverse(i+1, j, q)
    if (j+1 < n and b[i][j+1] == q):
        b[i][j+1] = y
        traverse(i, j+1, q)

t = input()

for k in range(t):
    m, n = map(int, raw_input().split())
    a = [[int(j) for j in raw_input().split()] for i in range(m)]

    b = [[isPrime(a[j][i]) for i in range(n)] for j in range(m)]

    """print "Prime matrix"
    for i in range(m):
        for j in range(n):
            print (b[i][j]),
        print"""
    
    for i in range(m):
        for j in range(n):
            y  = 2
            #print "check point for ",i , j
            if (b[i][j] == 1):
                b[i][j] = y
                traverse(i, j, 1)
                #print "traversed for y = ",y, "b ", b[i][j]
                y =y+1
            
            if (b[i][j] == 0):
                b[i][j] = y
                traverse(i, j, 0)
                #print "traversed for y = ",y, "b ", b[i][j]
                y =y+1

    a = y-2
    y = 2
    for i in range(m):
        for j in range(n):
            #print "check point for ",i , j
            if (b[i][j] == 0):
                b[i][j] = y
                traverse(i, j, 0)
                #print "traversed for y = ",y, "b ", b[i][j]
                y =y+1


    print "Output::"
    for j in range(m):
        for i in range(n):
            print (b[j][i]),
        print

    print a, y-2
