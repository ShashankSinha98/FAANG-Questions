t = int(input())

def days(arr:[],n:int):
    minima = []
    maxima = []

    mini = True
    for i in range(n):

        if mini:
            if i+1!=n and arr[i]<arr[i+1]:
                minima.append(i)
                mini = False
        else:
            if i+1!=n and arr[i]>arr[i+1]:
                maxima.append(i)
                mini = True
            
            if i+1==n:
                maxima.append(i)
    #print(minima)
    #print(maxima)
    if len(minima)==0:
        return "No Profit"
    else:
        k = len(maxima)
        res = ""
        for i in range(k):
            res+="("+str(minima[i])+" "+str(maxima[i])+") "
        return res




while t!=0:
    t-=1
    n = int(input())
    arr = [int(i) for i in input().split()]
    print(days(arr,n))