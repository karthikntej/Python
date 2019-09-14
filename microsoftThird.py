def c(i,x):
    return a[i][x] is 'x'
def r(i,x):
    a[i][x] = 'o'

def d(i,x):
    if (x != 0 and c(i,x-1)):
        r(i,x-1)
    if (x != n-1 and c(i,x+1)):
        r(i,x+1)
    if (i != 0 and c(i-1,x)):
        r(i-1,x)
    if (i != m-1 and c(i+1,x)):
        r(i+1,x)

t = input()
for k in range(t):
    m, n = map(int, raw_input().split())
    a = [list(raw_input()) for i in range(m)]
    for i,v in enumerate(a):
        while 'r' in v:
            x = v.index('r')
            r(i,x)
            d(i,x)
            if (x != 0):
                if (i != 0 and c(i-1,x-1)):                
                    r(i-1,x-1)
                if (i != m-1 and c(i+1,x-1) ):
                    r(i+1,x-1)
            if (x != n-1):
                if (i != 0 and c(i-1,x+1)):
                    r(i-1,x+1)
                if (i != m-1 and c(i+1,x+1) ):
                    r(i+1,x+1)
        while 'b' in v:
            x = v.index('b')
            a[i][x] = 'B'
            d(i,x)
    p = 0
    for i in a:
        p += i.count('x')
    print p


