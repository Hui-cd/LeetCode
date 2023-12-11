package Compition.Leet.Week84;

import java.util.HashMap;

/**
 * 给你一个下标从 0 开始的正整数数组 tasks ，表示需要 按顺序 完成的任务，其中 tasks[i] 表示第 i 件任务的 类型 。
 *
 * 同时给你一个正整数 space ，表示一个任务完成 后 ，另一个 相同 类型任务完成前需要间隔的 最少 天数。
 *
 * 在所有任务完成前的每一天，你都必须进行以下两种操作中的一种：
 *
 * 完成 tasks 中的下一个任务
 * 休息一天
 * 请你返回完成所有任务所需的 最少 天数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：tasks = [1,2,1,2,3,1], space = 3
 * 输出：9
 * 解释：
 * 9 天完成所有任务的一种方法是：
 * 第 1 天：完成任务 0 。
 * 第 2 天：完成任务 1 。
 * 第 3 天：休息。
 * 第 4 天：休息。
 * 第 5 天：完成任务 2 。
 * 第 6 天：完成任务 3 。
 * 第 7 天：休息。
 * 第 8 天：完成任务 4 。
 * 第 9 天：完成任务 5 。
 * 可以证明无法少于 9 天完成所有任务。
 */
public class TaskSchedulerII {
    /**
     *
     *         贪心+HashMap:
     *         注意:任务要按顺序完成
     *         HashMap存储下一次能做任务key的最早时间是第几天
     *         例如第一天做了任务1，那么要相隔3天，下一个能做任务1的最短时间就是第5天
     *         维护一个当前的天数cur，遍历当前的任务列表
     *         1.当cur能完成时task[i]时(map中存在该天数或者cur>=map[task[i]]) 当天完成该任务 cur++ 并更新map的天数
     *         2.当cur不能完成时task[i]时(cur<map[task[i]]) 此时只能等到map[task[i]]那天，直接cur=map[task[i]]然后完成，cur++
     *             并更新map对应的天数
     *         当遍历完最后一个时，返回cur-1就是答案
     *
     * @param tasks
     * @param space
     * @return
     */
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer, Integer> tasksMap = new HashMap<>();
        long cur = 1;
        for (int k: tasks){
            if (tasksMap.containsKey(k)&& cur < tasksMap.get(k)){
                cur = tasksMap.get(k);
            }
            tasksMap.put(k, (int) (cur+ space+1));
            cur++;
        }
        System.out.println(tasksMap);
        System.out.println(cur);
        return cur-1;
    }

    public static void main(String[] args) {
        TaskSchedulerII taskSchedulerII = new TaskSchedulerII();
        int[] tasks = {1,2,1,2,3,1};
        int space =3;
        taskSchedulerII.taskSchedulerII(tasks,space);
    }
}
