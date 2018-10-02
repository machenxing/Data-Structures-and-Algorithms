package Algorithms.Sort;

import java.util.Arrays;

/**
 * ¶ÑÅÅĞò
 */
public class HeapSort extends Sort {
    public void heapSort(int[] array){
        if(array.length>1){
            for(int i=array.length/2;i>=0;i--){
                heapAdjust(array,i,array.length);
            }
            for(int i=array.length-1;i>=1;i--){
                swap(array,0,i);
                heapAdjust(array,0,i);
            }
        }

    }
    public void heapAdjust(int[] array,int i,int length){
        int data=array[i];
        for(int j=2*i+1;j<=length-1;j=2*j+1){
            if(j<length-1 && array[j]<array[j+1]){
                j++;
            }
            if(data>=array[j]){
                break;
            }
            array[i]=array[j];
            i=j;
        }
        array[i]=data;
    }

    public static void main(String[] args) {
        int[] array={9,1,5,8,3,7,4,6,2};
        System.out.println(Arrays.toString(array));
        HeapSort heapSort=new HeapSort();
        heapSort.heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
