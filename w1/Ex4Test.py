import unittest

class AdditionTestCase(unittest.TestCase):
    def test_dupe(self):
        result = Check_dupe([3, 2, 2, 4, 5, 6])
        assert result == "There are duplicate"
    
    def test_noDupe(self):
        result = Check_dupe([x for x in range(100)])
        assert result == 'There are no duplicate'

    def test_noargs(self):
        result = Check_dupe([])
        assert result == 'There are no duplicate'
    
        

def Check_dupe(Arr):
    Arr.sort()
    if len(Arr) == 0:
        return 'There are no duplicate'
    for i in range(len(Arr)-1):
        if Arr[i] == Arr[i+1]:
            return "There are duplicate"
        else:
            return 'There are no duplicate'
if __name__=='__main__':
    unittest.main()

