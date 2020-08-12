t = int(input())

def max_square(arr:[[]],n:int,m:int)->int:

    dp = [[0]*(m+1) for i in range(n+1)]

    max_area = 0

    for i in range(1,n+1):
        for j in range(1,m+1):
            if arr[i-1][j-1]!=0:
                dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+arr[i-1][j-1]
                max_area = max(max_area,dp[i][j])
            else:
                dp[i][j] = 0
    print(dp)
    
    return max_area
    


while t!=0:
    t-=1
    n,m = [int(i) for i in input().split()]
    mat = [[0]*m for i in range(n)]
    arr = [int(i) for i in input().split()]

    k = 0
    for i in range(n):
        for j in range(m):
            mat[i][j] = arr[k]
            k+=1
    print(max_square(mat,n,m))

    


