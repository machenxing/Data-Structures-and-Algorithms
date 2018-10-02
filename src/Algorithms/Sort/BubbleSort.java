package Algorithms.Sort;

import java.util.Arrays;

/**
 * √∞≈›≈≈–Ú
 */
public class BubbleSort {
    /**
     * √∞≈›≈≈–Ú
     */
    public void bubbleSort(int[] array){
        if(array.length<2){
            return;
        }
        int i,j;
        for(i=0;i<array.length-1;i++){
            for(j=array.length-1;j>i;j--){
                if(array[j]<array[j-1]){
                    int data=array[j];
                    array[j]=array[j-1];
                    array[j-1]=data;
                }
            }
        }
    }
    /**
     * ”≈ªØµƒ√∞≈›≈≈–Ú
     */
    public void bubbleSort2(int[] array){
        if(array.length<2){
            return;
        }
        int i,j;
        boolean flag=true;
        for(i=0 ; i<array.length-1 && flag ; i++){
            flag=false;
            for(j=array.length-1;j>i;j--){
                if(array[j]<array[j-1]){
                    int data=array[j];
                    array[j]=array[j-1];
                    array[j-1]=data;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array={9,1,5,8,3,7,4,6,2};
        System.out.println(Arrays.toString(array));
        BubbleSort bubbleSort=new BubbleSort();
        bubbleSort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
        int[] array2={2,1,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(array2));
        bubbleSort.bubbleSort2(array2);
        System.out.println(Arrays.toString(array2));
    }
}
