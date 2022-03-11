/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。

 * */
public class TwoNumberSum {
    public static int[] twoSumMethod1(int[] nums, int target) {
        int length = nums.length;
        for(int i=0;i<length;i++){
            for (int j = 0; j< length;j++){
            if ( nums [i]+ nums[j] == target){
                return new int[] {i,j};
            }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,5,6,6,7};
        int target = 3;
        int [] result = twoSumMethod1(nums,target);
        for (int i = 0; i < result.length;i++){
            System.out.println(result[i]+"");
        }
    }
}
