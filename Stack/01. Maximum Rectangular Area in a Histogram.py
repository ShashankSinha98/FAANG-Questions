t = int(input())

def max_area(arr,n):

    stack = []

    max_area = 0
    i = 0

    while i < n:
        if len(stack)==0 or arr[stack[-1]]<=arr[i]:
            stack.append(i)
            i+=1
        else:
            top = stack.pop()
            area = 0
            if len(stack)==0:
                area = arr[top] * i
            else:
                area = arr[top] * (i-stack[-1]-1)

            
            max_area = max(max_area,area)

    while len(stack)!=0:
        top = stack.pop()
        area = 0
        if len(stack)==0:
            area = arr[top] * i
        else:
            area = arr[top] * (i-stack[-1]-1)
        
        max_area = max(max_area,area)

    return max_area





while t!=0:
    t-=1

    n = int(input())
    arr = [int(i) for i in input().split()]
    res = max_area(arr,n)
    print(res)