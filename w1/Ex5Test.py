import unittest

class ThreeSum_testcase(unittest.TestCase):
    def test_threesum(self):
        result = threeSum([-1,-2,0,1,2,-3,4,-3])
        assert result == [(-1, 4, -3), (1, 2, -3), (0, 2, -2), (0, 1, -1)]
    
    def test_lessthan_3_ele(self):
        result = threeSum([-1,-2])
        assert result == []

    def test_no_neg(self):
        result = threeSum([1,2,3,4,5,6])
        assert result == []

    def test_no_pos(self):
        result = threeSum([-1,-2,-3,-4,-5,-6])
        assert result == []

    def test_no_sumzero(self):
        result = threeSum([-1,-2,-3,0,6,7,8])
        assert result == []

    def test_emtylist(self):
        result = threeSum([])
        assert result == []

    def test_dupeinlist(self):
        result = threeSum([-1,-1,-2,0,1,2,-3,4,-3])
        assert result == [(-1, 4, -3), (1, 2, -3), (0, 2, -2), (-1, 2, -1), (0, 1, -1)]
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
                ans.append((arr[l],arr[r],j))
                r-=1
    return ans

if __name__=='__main__':
    unittest.main()