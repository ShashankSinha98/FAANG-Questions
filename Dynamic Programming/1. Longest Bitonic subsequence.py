# https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence/0

t = int(input())

def longest_bitonic_seq(arr,n):

    left = [1 for i in range(n)]
    right = [1 for i in range(n)]

    for i in range(1,n):
        best = 0
        for j in range(0,i):
            if arr[j]<arr[i]:
                best = max(best,left[j])
        left[i] = best + 1

    for i in range(n-2,-1,-1):
        best = 0
        for j in range(i+1,n):
            if arr[i]>arr[j]:
                best = max(best,right[j])
        right[i] = best + 1

    #print(left)
    #print(right)

    res = 0
    for i in range(n):
        res = max(res,left[i]+right[i]-1)

    return res




while t!=0:
    t-=1

    n = int(input())
    arr = [int(i) for i in input().split()]
    res = longest_bitonic_seq(arr,n)
    print(res)
