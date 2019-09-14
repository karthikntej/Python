def P(n):
 if n>1:
  for i in range(2,n):
   if(n%i)==0:
    return 0
   else:
    return 1
 else:
  return 0
def T(i,j,q):
 if(i-1<m and i-1>=0 and b[i-1][j]==q):
  b[i-1][j]=y
  T(i-1,j,q)
 if(j-1<n and j-1>=0 and b[i][j-1]==q):
  b[i][j-1]=y
  T(i,j-1,q)
 if(i+1<m and b[i+1][j]==q):
  b[i+1][j]=y
  T(i+1,j,q)
 if(j+1<n and b[i][j+1]==q):
  b[i][j+1]=y
  T(i,j+1,q)
t=input()
for k in range(t):
 m,n=map(int,raw_input().split())
 a=[[int(j)for j in raw_input().split()]for i in range(m)]
 b=[[P(a[j][i])for i in range(n)]for j in range(m)]
 y=2
 for i in range(m):
  for j in range(n):
   if(b[i][j]==1):
    b[i][j]=y
    T(i,j,1)
    y=y+1
 a=y-2
 y=2
 for i in range(m):
  for j in range(n):
   if(b[i][j]==0):
    b[i][j]=y
    T(i,j,0)
    y=y+1
 print a,y-2
