package Compition.Leet.Week84;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个下标从 0 开始的整数数组 nums 。如果 i < j 且 j - i != nums[j] - nums[i] ，那么我们称 (i, j) 是一个 坏数对 。
 *
 * 请你返回 nums 中 坏数对 的总数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,3,3]
 * 输出：5
 * 解释：数对 (0, 1) 是坏数对，因为 1 - 0 != 1 - 4 。
 * 数对 (0, 2) 是坏数对，因为 2 - 0 != 3 - 4, 2 != -1 。
 * 数对 (0, 3) 是坏数对，因为 3 - 0 != 3 - 4, 3 != -1 。
 * 数对 (1, 2) 是坏数对，因为 2 - 1 != 3 - 1, 1 != 2 。
 * 数对 (2, 3) 是坏数对，因为 3 - 2 != 3 - 3, 1 != 0 。
 * 总共有 5 个坏数对，所以我们返回 5 。
 */


/**
 * 解题思路 总数对 - 好数对
 */
public class CountBadPairs {
    public long countBadPairs(int[] nums) {
        int n=nums.length;
        long cnt=(long)(1.0d*(1+n-1)*(n-1)/2);
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int d=nums[i]-i;
            map.put(d,map.getOrDefault(d,0)+1);
        }
        for(int count:map.values()){
            cnt-=(long)(1.0d*(1+count-1)*(count-1)/2);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        CountBadPairs test = new CountBadPairs();
        long result = test.countBadPairs(nums);
        System.out.println(result);
    }
}
