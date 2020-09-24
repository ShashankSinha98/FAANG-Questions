def solve(arr,target):

    dp = [[False]*(target+1) for i in range(len(arr)+1)]

    for i in range(target+1):
        dp[0][i] = False

    for i in range(len(arr)+1):
        dp[i][0] = True

    for i in range(1,len(arr)+1):
        for j in range(1,target+1):

            if(arr[i-1] <= j):
                dp[i][j] = dp[i-1][j] or dp[i-1][j-arr[i-1]]
            else:
                dp[i][j] = dp[i-1][j]
    

    return dp[len(arr)][target]









arr = [int(i) for i in input().split()]
print(sum(arr))
if sum(arr)//2 != sum(arr)/2:
    print("No")
else:
    ans = solve(arr,sum(arr)//2)
    if(ans):
        print("Yes")
    else:
        print("No")