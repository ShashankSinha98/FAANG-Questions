t = int(input())

while t!=0:
    t-=1

    inp = input()
    n = len(inp)
    ans = 0

    for i in range(n):
        if inp[i]=='1':
            # Odd
            if (n-i-1) & 1 > 0:
                ans+=2
            else:
                ans+=1
        
    #print("ans->",ans)
    if ans % 3 == 0:
        print(1)
    else:
        print(0)
