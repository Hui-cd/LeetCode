

```java
class Solution {
    /**先判断nums的length如果小于3就直接返回其length
    nums[k]可以看作是一个空的array,从nums的第三个元素开始比较，如果这些元素都不在
    nums[k-2]里面就将其加入到nums[k]中，就是假设nums[k]中有n个元素，和前n-1个元素进行比较
    如果不在里面就加入到里面，不用和第n个比较，因为这只有两种可能要么一样要么不一样，如果一样
    就刚好是两个一样的元素在nums[k]这个数组里面
    */
    public int removeDuplicates(int[] nums) {
        int k = 2;
        if(nums.length < 3){
            return nums.length;
        }

        for(int i =2;i< nums.length;i++){
            if(nums[i]!=nums[k-2]){
                nums[k] =nums[i];
                k++;
            }
        }
        return k;

    }
}
```