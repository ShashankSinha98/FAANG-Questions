# https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair/0

MOD = 10**9+7

t = int(input())

def precompute_ans(n):
    
    dp = [0 for i in range(n+1)]

    dp[0] = dp[1] = 1

    for i in range(2,n+1):
        dp[i] = (dp[i-1]+dp[i-2]) % MOD

    return dp


res = precompute_ans(10**5+5)

while t!=0:
    t-=1

    n = int(input())
    print(res[n])