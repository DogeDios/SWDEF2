# This is the better version

def threeSum(arr):
    arr.sort()
    ans = []
    if len(arr)<3:
        return []
    for i,j in enumerate(arr):
        l = i+1
        r = len(arr)-1
        while l < r:
            if i>0 and arr[i-1] == j:
                break
            summ = j+arr[l]+arr[r]
            if summ<0:
                l+=1
            elif summ>0:
                r-=1
            else:
                ans.append([arr[l],arr[r],j])
                r-=1
    return ans

arr = [-1,-2,0,1,2,-3,4,-3]
print(threeSum(arr))

