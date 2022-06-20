/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 */
public class IntReverse {
    public int reverse(int x) {
        int temp;
        int result = 0;
            while (x!=0){
                temp = x%10;
                if (result>214748364 || (result==214748364 && temp>7)) {
                    return 0;
                }
                if (result<-214748364 || (result==-214748364 && temp<-8)) {
                    return 0;
                }
                result =temp+result*10;
                x=(x-temp)/10;
            }
        return result;
    }

    public static void main(String[] args) {
        IntReverse intReverse = new IntReverse();
        int x = intReverse.reverse(-119);
        System.out.println(x);
    }
}
