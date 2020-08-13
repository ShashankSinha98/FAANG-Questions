
# https://www.geeksforgeeks.org/min-cost-path-dp-6/

#n = 3
#arr = [[1,2,3],[4,8,2],[1,5,3]]
import sys

def solve(arr,dp,i,j,n):

    if i==0 and 0<=j<n:
       return arr[i][j]

    if j==n or j<0:
        return 0

    if dp[i][j] != -1:
        return dp[i][j]
    
    
    
    dp[i][j] = max(solve(arr,dp,i-1,j,n),solve(arr,dp,i-1,j-1,n),solve(arr,dp,i-1,j+1,n))+arr[i][j]
   
    return dp[i][j]




t = int(input())

while t!=0:
    t-=1
    
    n = int(input())
    arr = [[0]*n for i in range(n)]

    data = [int(i) for i in input().split()]
    k = 0
    for i in range(n):
        for j in range(n):
            arr[i][j] = data[k]
            k+=1
            
    
    res = -sys.maxsize
    for j in range(n):
        dp = [[-1]*n for i in range(n)]
        res = max(res,solve(arr,dp,n-1,j,n))


    print(res)

