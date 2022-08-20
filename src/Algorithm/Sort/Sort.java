package Algorithm.Sort;

public class Sort {
    public int[] binaryInsertSort(int[] array){
        if(array==null||array.length==0) return array;
        for(int i=1;i<array.length;i++){
            int temp = array[i];
            int low = 0;
            int high = i-1;
            while(low<=high){
                int mid = (low+high)/2;
                if(array[mid]>temp){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            for(int j=i-1;j>=low;j--){
                array[j+1] = array[j];
            }
            array[low] = temp;
        }
        return array;
    }

    public int[] bubbleSort(int[] array){
        if(array==null||array.length==0) return array;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public int[] quickSort(int[] array,int low,int high){
        if(array==null||array.length==0) return array;
        quickSort(array,0,array.length-1);
        return array;
    }

}
