def merge1(nums1, m, nums2, n):
    """
    :type nums1: List[int]
    :type m: int
    :type nums2: List[int]
    :type n: int
    :rtype: None Do not return anything, modify nums1 in-place instead.
    
    将nums2加入到nums1 使用 nums[m:]
    再用sort()排序
    """
    nums1[m:] = nums2
    nums1.sort()
    return nums1



def merge2( nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """
        

     
nums1 = [1,2,3,0,0,0]
nums2 = [2,5,6]
m = 6
n= 3

nums = merge2(nums1,m,nums2,n)
print(nums)