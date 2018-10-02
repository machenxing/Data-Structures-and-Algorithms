package Algorithms.Sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergingSort {
    /**
     * 递归实现归并排序
     */
    public void mergeSort(int[] array){
        if(array.length>1){
            mSort(array,0,array.length-1);
        }
    }
    /**
     * 数组拆分
     */
    private void mSort(int[] array, int left , int right){
        if(left<right){
            int mid=(left+right)/2;
            mSort(array,left,mid);
            mSort(array,mid+1,right);
            merge(array,left,mid,right);
        }
    }
    /**
     * 数组归并
     */
    private void merge(int[] array , int left , int mid , int right){
        int[] num=new int[right-left+1];
        int i = left;
        int j = mid+1;
        int count=0;
        while(i<=mid && j<=right){
            if(array[i]>array[j]){
                num[count++]=array[j++];
            }else{
                num[count++]=array[i++];
            }
        }
        while(i<=mid){
            num[count++]=array[i++];
        }
        while(j<=right){
            num[count++]=array[j++];
        }
        count=0;
        while(left<=right){
            array[left++]=num[count++];
        }
    }

    /**
     * 非递归实现归并排序
     */
    public void mergeSort2(int[] array){
        if(array.length>1){
            int length=1;
            while(length<array.length){
                for(int i=0;i<array.length-1;i+=2*length){
                    if(i+2*length<array.length){
                        merge(array,i,i+length-1,i+2*length-1);
                    }else if(i+length<array.length){
                        merge(array,i,i+length-1,array.length-1);
                    }else{
                        merge(array,i,array.length-1,array.length-1);
                    }
                }
                length *=2;
            }
        }
    }

    public static void main(String[] args) {
        int[] array={9,1,5,8,3,7,4,6,2};
        System.out.println(Arrays.toString(array));
        MergingSort mergingSort=new MergingSort();
        mergingSort.mergeSort(array);
        System.out.println(Arrays.toString(array));
        int[] array2={9,1,5,8,3,7,4,6,2};
        System.out.println(Arrays.toString(array2));
        mergingSort.mergeSort2(array2);
        System.out.println(Arrays.toString(array2));
    }
}
