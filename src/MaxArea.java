/**
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 *
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int n = 0;
        int m = height.length-1;
        int answer =0;
        while (n<m){
            int are = Math.min(height[m]*height[m-1],height[n]);
            answer = Math.max(answer,are);
            if (height[n]<=height[m]){
                ++n;
            }else {
                --m;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1,8,6,2,5,4,8,3,7};
        MaxArea maxArea = new MaxArea();
        int x = maxArea.maxArea(array);
        System.out.println(x);
    }
}
