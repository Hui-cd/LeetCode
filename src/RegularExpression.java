/**
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 * 示例 1：
 *
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 */
public class RegularExpression {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // s为空，p不为空，由于*可以匹配0个字符，所以有可能为true
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*' && dp[0][i - 2]) {
                dp[0][i] = true;
            }
            //            if (p.charAt(i - 1) == '*') {
            //                dp[0][i] = dp[0][i - 2];
            //            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if ((p.charAt(j - 1) == '.') || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                        // 匹配0个，或多次
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        // 匹配0个
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        RegularExpression regularExpression = new RegularExpression();
        boolean x = regularExpression.isMatch("ab","a*");
        System.out.println(x);
    }
}
