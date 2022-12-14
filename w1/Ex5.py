myArray = [0,-1,2,-3,1,-2]
myArray.sort()
# -3 -2 -1 0 1 2

firstHalf = [x for x in myArray[0:int(len(myArray)/2)]]
secondHalf = [x for x in myArray[int(len(myArray)/2):len(myArray)]]

for i in range(0,int(len(myArray))):
    if firstHalf[i] + secondHalf[-1] == 0:
        pass
    else:
        pass

# ขกทำละว่างๆก็มาลอง

print(secondHalf)