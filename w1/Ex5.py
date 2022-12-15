myArray = [0,-1,2,-3,1,-2]
myArray.sort()
# -3 -2 -1 0 1 2

for i in range(len(myArray)):
    for j in range(1,len(myArray)):
        a = myArray[i]+myArray[j]
        if myArray[i] != a and myArray[j] != a and myArray[i] != myArray[j]:
            pass




# ขกทำละว่างๆก็มาลอง

print(1)