package Algorithms.Sort;

import java.util.Arrays;

/**
 * Ö±½Ó²åÈëÅÅÐò
 */
public class StraightInsertionSort {
    public void insertSort(int[] array){
        if(array.length>1){
            int i,j;
            for(i=1;i<array.length;i++){
                if(array[i-1]>array[i]){
                    int data=array[i];
                    for(j=i;j>0 && array[j-1]>data;j--){
                        array[j]=array[j-1];
                    }
                    array[j]=data;
                }

            }
        }
    }

    public static void main(String[] args) {
        int[] array={9,1,5,8,3,7,4,6,2};
        System.out.println(Arrays.toString(array));
        StraightInsertionSort straightInsertionSort=new StraightInsertionSort();
        straightInsertionSort.insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
