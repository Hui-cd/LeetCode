package Compition.Leet.Week84;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你两个二维整数数组 items1 和 items2 ，表示两个物品集合。每个数组 items 有以下特质：
 *
 * items[i] = [valuei, weighti] 其中 valuei 表示第 i 件物品的 价值 ，weighti 表示第 i 件物品的 重量 。
 * items 中每件物品的价值都是 唯一的 。
 * 请你返回一个二维数组 ret，其中 ret[i] = [valuei, weighti]， weighti 是所有价值为 valuei 物品的 重量之和 。
 *
 * 注意：ret 应该按价值 升序 排序后返回。
 *
 * 输入：items1 = [[1,1],[4,5],[3,8]], items2 = [[3,1],[1,5]]
 * 输出：[[1,6],[3,9],[4,5]]
 * 解释：
 * value = 1 的物品在 items1 中 weight = 1 ，在 items2 中 weight = 5 ，总重量为 1 + 5 = 6 。
 * value = 3 的物品再 items1 中 weight = 8 ，在 items2 中 weight = 1 ，总重量为 8 + 1 = 9 。
 * value = 4 的物品在 items1 中 weight = 5 ，总重量为 5 。
 * 所以，我们返回 [[1,6],[3,9],[4,5]] 。
 */

public class MergeSimilarItems {
    /**
     * 解题思路 可以用hashmap的特性进行合并
     * @param items1
     * @param items2
     * @return
     */
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer, Integer> ret = new HashMap<>();
        for (int i = 0; i< items1.length;i++){
            ret.put(items1[i][0],ret.getOrDefault(items1[i][0],0)+ items1[i][1]);
        }

        for (int i = 0; i< items2.length;i++){
            ret.put(items2[i][0],ret.getOrDefault(items2[i][0],0)+ items2[i][1]);
        }
        List<List<Integer>> result = new LinkedList<>();
        Object[] keyList = ret.keySet().toArray();
        Arrays.sort((keyList));
        for (Object key: keyList){
            Integer val = (Integer) key;
            List<Integer> ls = new LinkedList<>();
            ls.add(val);
            ls.add(ret.get(val));
            result.add(ls);
        }
        return result;
    }
}
