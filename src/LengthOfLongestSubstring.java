/**
 * 无重复字符的最长子串
 * 
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int max = 0;
        int start = 0;
        int end  = 0;
        int[] map = new int[256];
        while(end<length){
            if(map[s.charAt(end)]==0){
                map[s.charAt(end)]++;
                end++;
            }else {
                max = Math.max(max,end-start);
                map[s.charAt(start)]--;
                start++;

            }
        }
        max = Math.max(max,end-start);
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcabc";
        LengthOfLongestSubstring lengthOfLangthOfLongestSubstring = new LengthOfLongestSubstring();
        int result = lengthOfLangthOfLongestSubstring.lengthOfLongestSubstring(s);
        System.out.println(result);

    }
}

