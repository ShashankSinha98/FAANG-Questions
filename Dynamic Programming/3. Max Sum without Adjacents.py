# https://practice.geeksforgeeks.org/problems/stickler-theif/0
# https://practice.geeksforgeeks.org/problems/max-sum-without-adjacents/0

t = int(input())

def max_sum(arr,n):

    if n==1:
        return arr[0]

    dp = [0 for i in range(n+1)]
    dp[1] = arr[0]
    dp[2] = max(arr[0],arr[1])

    for i in range(3,n+1):
        dp[i] = max(dp[i-2]+arr[i-1],dp[i-1])
    
    #print(dp)
    return dp[n]

while t!=0:
    t-=1

    n = int(input())
    arr = [int(i) for i in input().split()]
    res = max_sum(arr,n)
    print(res)
