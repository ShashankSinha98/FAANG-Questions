t = int(input())

def common_lcs(str1,n,str2,m):

    dp = [[0]*(m+1) for i in range(n+1)]

    for i in range(1,n+1):
        for j in range(1,m+1):
            if str1[i-1]==str2[j-1]:
                dp[i][j] = dp[i-1][j-1] + 1
            else:
                dp[i][j] = max(dp[i-1][j],dp[i][j-1])
    
    return dp[n][m]

def display(arr):
    for i in arr:
        for j in i:
            print(j,end=" ")
        print()
    print()


while t!=0:
    t-=1

    n,m = [int(i) for i in input().split()]
    str1 = input()
    str2 = input()
    res = common_lcs(str1,n,str2,m)
    print(res)