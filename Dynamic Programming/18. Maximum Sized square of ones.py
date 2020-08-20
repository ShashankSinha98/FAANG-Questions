# Jake loves to play with matrix. Given a 2D binary matrix filled with 0's and 1's, 
# help him find the maximum sized square containing only 1's and return its area.

n, m = 4, 5

grid = [[1, 0, 1, 0, 0],
        [1, 0, 1, 1, 1],
        [1, 1, 1, 1, 1],
        [1, 0, 1, 1, 1]]

def find_max_square(grid,n,m):

    dp = [[0]*(m+1) for i in range(n+1)]
    max_len = -1
    for i in range(1,n+1):
        for j in range(1,m+1):
            if grid[i-1][j-1] != 0:
                dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+grid[i-1][j-1]
                max_len = max(max_len,dp[i][j])
            else:
                dp[i][j] = 0

    return max_len*max_len


print(find_max_square(grid,n,m))
    