#   You are given 2 strings s1 and s2. You can perform the following operations on them:

#   1. Insert a character at any position.
#   2. Remove a character from any position.
#   3. Replace a character with any other character.
#
#   Find the minimum number of these operations required to convert s1 to s2.


def top_down(s1,s2,i,j):
    global dp

    # base case
    if i == len(s1):
        return len(s2)-j
    elif j == len(s2):
        return len(s1)-i
    
    # Look up
    if dp[i][j] != -1:
        return dp[i][j]

    # recc case
    res = -1
    if s1[i] != s2[j]:
        res = min(top_down(s1,s2,i,j+1), top_down(s1,s2,i+1,j), top_down(s1,s2,i+1,j+1)) + 1
    else:
        res = min(1 + top_down(s1,s2,i,j+1),1 + top_down(s1,s2,i+1,j), top_down(s1,s2,i+1,j+1)) 
    
    return res

 



s1 = input()
s2 = input()
m,n = len(s1),len(s2)

dp = [[-1]*(n+1) for i in range(m+1)]

res = top_down(s1,s2,0,0)
print(res)