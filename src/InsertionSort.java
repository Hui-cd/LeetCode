public class InsertionSort {
    /**
     * 插入排序算法
     *
     * 算法逻辑:
     * 两两对比，小的在前，每次循环都要对前面的进行排序
     * @param array array[1,3,2,5,4]
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
