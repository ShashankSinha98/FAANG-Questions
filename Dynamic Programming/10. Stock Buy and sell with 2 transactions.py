prices = [int(i) for i in input().split()]
n = len(prices)
#n = 8
#prices = [3,3,5,0,0,3,1,4]


def max_profit(prices,n):
    minima = [0]*n
    maxima = [0]*n

    minima[1] = prices[0]
    for i in range(2,n):
        minima[i] = min(minima[i-1],prices[i-1])

    maxima[-2] = prices[-1]
    for i in range(n-3,-1,-1):
        maxima[i] = max(maxima[i+1],prices[i+1])

    left = [0]*n
    right = [0]*n

    for i in range(1,n):
        left[i] = max(left[i-1],prices[i]-minima[i])

    for i in range(n-2,-1,-1):
        right[i] = max(right[i+1],maxima[i]-prices[i])

    

    max_profit = 0
    for i in range(n):
        max_profit = max(max_profit,left[i]+right[i])
    
    return max_profit

res = max_profit(prices,n)
print(res)