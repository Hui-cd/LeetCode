import unittest

def removeElement( nums, val):
    m = len(nums)
    print(m)
    for i in range(m):
        if nums[i] == val:
            nums[i] =0
    return nums

class TestRemoveElement(unittest.TestCase):
    def test_remove_element_case1(self):
        nums = [0, 1, 2, 2, 3, 0, 4, 2]
        val = 2
        expected_result = [0, 1, 4, 0, 3]
        self.assertEqual(removeElement(nums, val), expected_result)

    def test_remove_element_case2(self):
        nums = [0, 1, 2, 2, 3, 0, 4, 2]
        val = 2
        expected_result = [2, 2]
        self.assertEqual(removeElement(nums, val), expected_result)
if __name__ == '__main__':
    unittest.main()