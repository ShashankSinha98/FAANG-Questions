t = int(input())


def max_area_under_hist(arr,n):

    max_area = 0
    stack = []
    i = 0
    while i<n:
        if len(stack)==0 or arr[stack[-1]]<=arr[i]:
            stack.append(i)
            i+=1
        else:
            top = stack.pop()

            if len(stack) == 0:
                area = arr[top] * i
            else:
                area = arr[top] * (i-stack[-1]-1)
            
            max_area = max(max_area,area)

    while len(stack)!=0:
        top = stack.pop()

        if len(stack) == 0:
            area = arr[top] * i
        else:
            area = arr[top] * (i-stack[-1]-1)
        
        max_area = max(max_area,area)

    return max_area

            
def max_area_rect(mat,n,m):

    max_area = 0
    arr = [0]*m

    for i in range(n):
        for j in range(m):
            if mat[i][j]!=0:
                arr[j] = arr[j] + mat[i][j]
            else:
                arr[j] = 0
        max_area = max(max_area, max_area_under_hist(arr,m))

    return max_area 



while t!=0:
    t-=1
    n,m = [int(i) for i in input().split()]
    mat = [[0]*m for i in range(n)]
    inp = [int(i) for i in input().split()]

    k=0
    for i in range(n):
        for j in range(m):
            mat[i][j] = inp[k]
            k+=1
    print(max_area_rect(mat,n,m))





