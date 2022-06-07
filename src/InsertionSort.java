public class InsertionSort {
    /**
     * 插入排序算法
     * 算法逻辑:
     * 插入排序的工作原理是通过构建有序序列，
     * 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），
     * 因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     * @param array
     * @return
     */
    public int[] insertion(int[] array){
        int key = 0;
        int i = 0;
        for (int j =2;j<array.length;j++){
            key = array[j];
            i = j-1;
            while(i>0&&array[i]>key){
                array[i+1] = array[i];
                i = i -1;
            }
            array[i+1] = key;
        }
        return  array;
    }
}
