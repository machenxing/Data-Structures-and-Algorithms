package Algorithms.Sort;

import java.util.Arrays;

/**
 * Ï£¶ûÅÅÐò
 */
public class ShellSort extends Sort{
    public void shellSort(int[] array){
        if(array.length>1){
            int increment=array.length/2;
            while(increment>=1){
                for(int i=0;i<array.length;i++){
                    for(int j=i;j<array.length-increment;j +=increment){
                        if(array[j]>array[j+increment]){
                            swap(array,j,j+increment);
                        }
                    }
                }
                increment=increment/2;
            }
        }
    }

    public static void main(String[] args) {
        int[] array={9,1,5,8,3,7,4,6,2};
        System.out.println(Arrays.toString(array));
        ShellSort shellSort=new ShellSort();
        shellSort.shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}
