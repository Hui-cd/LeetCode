# Top Interview 150 

## 26. Remove Duplicates from Sorted Array

### 问题描述
给定一个非递减顺序排序的整数数组 `nums`，原地删除重复出现的元素，使每个元素只出现一次，并返回新的长度 `k`。不需要考虑数组中超出新长度后面的元素。

### 题解
- 首先先判断数组为空 直接返回0
- 那么这时候数组不为空，`nums[k]`其实是一个新的数组，可以看成为空的
- 然后将nums中的第一个元素加入进去
- 那么剩下的就是比较`nums`中剩余的元素和`nums[k]`中的是否重复
- 如果不重复就将元素加入到`nums[k]`中 如代码
- 
```java
if (nums[i] != nums[k-1] ) {
    nums[k] = nums[i];
    }
```

```java
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 1;
        for(int i = 1; i < nums.length; i++){
            if (nums[i] != nums[k-1] ) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}

```