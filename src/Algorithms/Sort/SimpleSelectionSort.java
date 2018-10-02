package Algorithms.Sort;

import java.util.Arrays;

/**
 * ¼òµ¥Ñ¡ÔñÅÅÐò
 */
public class SimpleSelectionSort extends Sort{
    public void selectSort(int[] array){
        if(array.length>1){
            int i,j,min;
            for(i=0;i<array.length-1;i++){
                min=i;
                for(j=min+1;j<array.length;j++){
                    if(array[min]>array[j]){
                        min=j;
                    }
                }
                if(min!=i){
                    swap(array,i,min);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array={9,1,5,8,3,7,4,6,2};
        System.out.println(Arrays.toString(array));
        SimpleSelectionSort simpleSelectionSort=new SimpleSelectionSort();
        simpleSelectionSort.selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
