import java.util.Arrays;

public class Merge{
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int x = 0;
        for(int i = 0;i<nums1.length;i++){
            if(i>m&&x<=n){
                nums1[i]=nums2[x];
                x+=1;
            }
        }
        Arrays.sort(nums1);
    }
}