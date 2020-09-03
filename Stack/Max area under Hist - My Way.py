
t = int(input())

while t!=0:
    t-=1
    n = int(input())

    arr = [int(i) for i in input().split()]

    
    st = []
    l2r = [0]*n
    r2l = [0]*n

    for i in range(n):
        if len(st)==0 or arr[st[-1]]<=arr[i]:
            st.append(i)
        else:
            while(len(st)!=0 and arr[st[-1]]>arr[i]):
                popped = st.pop()
                l2r[popped] = i
            st.append(i)

    while(len(st)!=0):
        popped = st.pop()
        l2r[popped] = n


    for i in range(n-1,-1,-1):
        if len(st)==0 or arr[st[-1]]<=arr[i]:
            st.append(i)
        else:
            while(len(st)!=0 and arr[st[-1]]>arr[i]):
                popped = st.pop()
                r2l[popped] = i
            st.append(i)
    
    while(len(st)!=0):
        popped = st.pop()
        r2l[popped] = -1


    maxArea = 0
    for i in range(n):
        area = 0
        if r2l[i]==-1:
            area = arr[i]*(l2r[i])
        else:
            area = arr[i]*(l2r[i]-r2l[i]-1)
        maxArea = max(area,maxArea )

    print(maxArea)
