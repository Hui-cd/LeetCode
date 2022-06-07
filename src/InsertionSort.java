public class InsertionSort {
    /**
     * 插入排序算法
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
