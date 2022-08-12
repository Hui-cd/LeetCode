package Compition.Leet.Week84;

/**
 * 给你一个下表从 0 开始的整数数组 nums 。每次操作中，你可以将数组中任何一个元素替换为 任意两个 和为该元素的数字。
 *
 * 比方说，nums = [5,6,7] 。一次操作中，我们可以将 nums[1] 替换成 2 和 4 ，将 nums 转变成 [5,2,4,7] 。
 * 请你执行上述操作，将数组变成元素按 非递减 顺序排列的数组，并返回所需的最少操作次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,9,3]
 * 输出：2
 * 解释：以下是将数组变成非递减顺序的步骤：
 * - [3,9,3] ，将9 变成 3 和 6 ，得到数组 [3,3,6,3]
 * - [3,3,6,3] ，将 6 变成 3 和 3 ，得到数组 [3,3,3,3,3]
 * 总共需要 2 步将数组变成非递减有序，所以我们返回 2 。
 */

public class MinimumReplacement {
    /**
     * 解题思路 贪心算法 建立数学模型
     * @param nums
     * @return
     */
    public long minimumReplacement(int[] nums) {
        var ans = 0L;
        var m = nums[nums.length - 1];
        for (var i = nums.length - 2; i >= 0; --i) {
            var k = (nums[i] - 1) / m;
            ans += k;
            m = nums[i] / (k + 1);
        }
        return ans;
    }
}
