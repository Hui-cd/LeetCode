# Top Interview 150 
## 88. Merge Sorted Array

### 题目描述

给定两个已排序的整数数组 `nums1` 和 `nums2`，以及两个整数 `m` 和 `n`，分别表示 `nums1` 和 `nums2` 中的元素数量。`nums1` 数组有足够的空间（长度至少为 `m + n`）来保存合并后的结果。

#### 要求

- 不需要返回新数组，而是直接在 `nums1` 数组中修改。
- 合并后的数组仍然保持非递减（升序）顺序。


### 解法1
将nums1中`m`个元素之后的元素改为`nums2`中的元素，最后对其进行`sort`
- 时间复杂度 $O((m+n) \log(m+n))$
- 空间复杂度 $O(n)$
``` java
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
```

### 解法2
就是比较两个数组第m个和第n个谁大，放到`nums1`的最后面，持续比较完成排序

#### 定义指针
首先定义三个指针变量：
- `midx`: 指向 `nums1` 中最后一个已经初始化的元素。
- `nidx`: 指向 `nums2` 中最后一个元素。
- `right`: 指向 `nums1` 应该填充的最后一个位置。

#### 从后向前比较
接下来，我们从后往前对 `nums1` 和 `nums2` 中的元素进行比较。我们要做的是将比较大的元素放在 `nums1` 的 `right` 指向的位置，因为这是目前未被填充的最后一个位置。

#### 填充逻辑
- 如果 `nums1` 的 `midx` 指向的元素大于 `nums2` 的 `nidx` 指向的元素，或者 `nums2` 已经比较完毕（`nidx < 0`），我们就将 `nums1[midx]` 放在 `right` 位置，然后将 `midx` 和 `right` 都向左移动一位。
- 如果 `nums2` 的 `nidx` 指向的元素大于 `nums1` 的 `midx` 指向的元素，我们就将 `nums2[nidx]` 放在 `right` 位置，然后将 `nidx` 和 `right` 都向左移动一位。

#### 循环直到完成
重复上述过程，直到 `nums2` 的所有元素都被复制到 `nums1` 中。由于 `nums1` 中剩余的位置正好足够放下 `nums2` 中所有的元素，这个过程能够完美地在不使用额外空间的情况下完成合并。


```java
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int midx = m - 1;
        int nidx = n - 1; 
        int right = m + n - 1;

      
        while (nidx >= 0) {
            
            if (midx < 0 || nums2[nidx] > nums1[midx]) {
                nums1[right] = nums2[nidx]; 
                nidx--; 
            } else {
                nums1[right] = nums1[midx]; 
                midx--; 
            }
            right--; 
        }

    }
}

```