def findduplicate (A):
    dupe=[]
    A.sort()
    for i in range(0,len(A)-1):
        if A[i]==A[i+1]:
            dupe.append(A[i])
    if dupe :
        print('There is Duplicate')
        print('which is ' , dupe)
    else:
        print('There is no Duplicate')

findduplicate([1,1,2,2,3,4,5,6,7])