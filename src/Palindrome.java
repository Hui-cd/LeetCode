public class Palindrome {
    public boolean palindromeStringRec(String s){
        int headPoint =0;
        int tailPoint = s.length()-1;
        if ((s==null || s.length()==0)&&headPoint<tailPoint) {
            return false;
        }

        if((tailPoint -headPoint == 1)&&s.charAt(headPoint)==s.charAt(tailPoint)){
            return true;
        }

        if(headPoint==tailPoint){
            return true;
        }
        if((s.charAt(headPoint)==s.charAt(tailPoint))&&(headPoint<tailPoint)){
            headPoint++;
            tailPoint--;
            return palindromeStringRec(s.substring(1,s.length()-1));
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        System.out.println(p.palindromeStringRec("abcba"));
        System.out.println(p.palindromeStringRec("bb"));
    }
}
