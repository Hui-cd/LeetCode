public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s==null || s.length()==0) {
            return "";
        }
        int maxLen = 0;
        String maxStr = "";
        for (int i=0; i<s.length(); i++) {
            String str1 = helper(s, i, i);
            String str2 = helper(s, i, i+1);
            String max = str1.length()>str2.length()?str1:str2;
            if (max.length()>maxLen) {
                maxLen = max.length();
                maxStr = max;
            }
        }
        return maxStr;
    }

    private String helper(String s, int i, int i2) {
        int left = i;
        int right = i2;
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
        
}
