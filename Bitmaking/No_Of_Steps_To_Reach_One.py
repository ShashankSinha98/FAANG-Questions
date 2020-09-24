import sys
dp = [0]*100005

def solve(n):
    global dp
    
    if n==1 or n==0:
        return 0

    if dp[n]!=0:
        return dp[n]
    
    x = sys.maxsize
    y = sys.maxsize

    if n&1!=0: # odd
        x = min(solve(n-1),solve(n+1))
    else:
        y = solve(n//2)
    
    dp[n] = min(x,y) + 1
    return min(x,y) + 1
        


t = int(input())

while t!=0:
    t-=1

    inp = int(input())
    print(solve(inp))