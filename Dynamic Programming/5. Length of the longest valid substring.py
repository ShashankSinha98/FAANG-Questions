# https://practice.geeksforgeeks.org/problems/longest-valid-parentheses/0/?track=sp-stack&batchId=152
# https://practice.geeksforgeeks.org/problems/valid-substring/0

t = int(input())


# Constant space, TC- O(n)
def longest_valid(inp):
    n = len(inp)

    res = 0

    l = r = 0
    for i in range(n):
        if inp[i]=='(':
            l+=1
        else:
            r+=1
        
        if l==r:
            res = max(res,2*l)
        elif r>l:
            l = r = 0


    l = r = 0
    for i in range(n-1,-1,-1):
        if inp[i]=='(':
            l+=1
        else:
            r+=1

        if l==r:
            res = max(res,2*l)
        elif l>r:
            l = r = 0
    
    return res

# Space- O(n), TC - O(n)
def longest_valid_stack(inp):

    stack = []
    stack.append(-1)

    maxlen = 0
    n = len(inp)
    for i in range(n):
        if inp[i]=='(':
            stack.append(i)
        else:
            stack.pop()
            if len(stack) != 0:
                l = i - stack[-1] 
                maxlen = max(l,maxlen)
            else:
                stack.append(i)
    return maxlen


while t!=0:
    t-=1

    inp = input()
    res = longest_valid_stack(inp)
    print(res)
