/**
 * 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        int[] nums = new int[length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<length1 && j< length2){
            if(nums1[i]<nums2[j]){
                nums[k] = nums1[i];
                i++;
            }
            else{
                nums[k]= nums2[j];
                j++;
            }
            k++;
        }
        while(i<length1){
            nums[k] = nums1[i];
            i++;
            k++;

        }
        while(i<length2){
            nums[k] = nums1[j];
            j++;
            k++;

        }
        if(length%2 == 0){
            return (nums[length/2]+ nums[length/2-1])/2.0;

        }
        else{
            return nums[length/2];

        }


    }

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        FindMedianSortedArrays findMedianSortedArrays  = new FindMedianSortedArrays();
        double result = findMedianSortedArrays.findMedianSortedArrays(nums1,nums2);
        System.out.println(result);
    }
}
