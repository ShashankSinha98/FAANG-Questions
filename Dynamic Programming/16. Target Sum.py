# https://www.geeksforgeeks.org/number-of-ways-to-calculate-a-target-number-using-only-array-elements/
import sys
import numpy as np
def solve(arr,n,val,s):
    global dp
    #print(n,val)

    if n==0 and val==0:
        return 1
    
    if n==0 and val!=0:
        return 0

    if dp[n][val] != sys.maxsize:
        #print("*")
        return dp[n][val]

    res = solve(arr,n-1,val+arr[n-1],s) + solve(arr,n-1,val-arr[n-1],s) #+ solve(arr,n-1,val,s)
    dp[n][val] = res

    return res




n, val = [int(i) for i in input().split()]
arr = [int(i) for i in input().split()]
s = sum(arr)
LIM = 10**6
dp = [[sys.maxsize]*(LIM) for i in range(n+1)]
#print(np.shape(dp))
print(solve(arr,n,val,s))

