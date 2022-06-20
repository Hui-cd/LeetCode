import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * PAHNAPLSIIGYIR
 *
 */
public class Z_Transformation {
    /**
     * 题解思路:
     *         e.g.: numRows = 4 , 则四个一列， 3 一个 第三位， 2 一个第二位， 1 则返回四个 以此类推
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(s);
        if (s.length()<2){
            return s;
        }
        List<StringBuilder> stringBuilders = new ArrayList<>();
        for (int i = 0; i<numRows;i++){
           stringBuilders.add(new StringBuilder());
        }

        int i = 0;
        int flag = -1;
        for (char c :s.toCharArray()){
            stringBuilders.get(i).append(c);
            //让i回到起始值
            if (i == 0 || i==numRows-1){
                flag = -flag;
            }
            i += flag;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder strBuilder:stringBuilders){
            stringBuilder.append(strBuilder);
        }
        return  stringBuilder.toString();
    }

    public static void main(String[] args) {
        Z_Transformation zTransformation = new Z_Transformation();
        String x = zTransformation.convert("PAYPALISHIRING",3);
        System.out.println(x);
    }
}
