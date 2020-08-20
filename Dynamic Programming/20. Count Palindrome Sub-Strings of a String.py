# https://practice.geeksforgeeks.org/problems/count-palindrome-sub-strings-of-a-string/0

def no_of_palindrome(inp_str,n):

    dp = [[False]*n for i in range(n)]

    for i in range(n):
        dp[i][i] = True

    cnt = 0
    for i in range(n-1):
        if inp_str[i]==inp_str[i+1]:
            cnt+=1
            dp[i][i+1] = True

    for i in range(2,n):
        x,y = 0,i
        
        while (y<n):
            #print(x,y)
            if inp_str[x] == inp_str[y] and dp[x+1][y-1]:
                dp[x][y] = True
                cnt += 1

            x+=1
            y+=1
    
    return cnt




t = int(input())

while t!=0:
    t-=1
    n = int(input())

    inp_str = input()
    print(no_of_palindrome(inp_str,n))