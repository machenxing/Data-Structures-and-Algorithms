package Algorithms.Sort;
/**
 * 调换数组中两个数的位置
 */
public class Sort {
    public void swap(int[] array,int i,int j){
        if(i<array.length&&j<array.length){
            int data=array[i];
            array[i]=array[j];
            array[j]=data;
        }
    }
}
