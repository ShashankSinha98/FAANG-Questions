def max_price(left,right):
    global dp, prices
    if right-left<=1:
        return 0 

    if dp[left][right] != -1:
        return dp[left][right]

    max_profit = 0
    for pivot in range(left+1, right):
        max_profit = max(max_profit,prices[left]*prices[pivot]*prices[right] + max_price(left,pivot) + max_price(pivot,right))
    
    dp[left][right] = max_profit

    return max_profit




n = 4
prices = [1,3,1,5,8,1]
dp = [[-1]*(2*n) for i in range(2*n)]
print(max_price(0,5))