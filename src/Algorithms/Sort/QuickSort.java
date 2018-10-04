package Algorithms.Sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    /**
     * 对数组进行快速排序
     */
    public void quickSort(int[] array){
        if(array.length>1){
            qSort(array,0,array.length-1);
        }
    }
    /**
     * 利用递归对数组子序列进行快速排序
     */
    private void qSort(int[] array,int left,int right){
        if(left<right){
            int pivot;
            pivot=partition(array,left,right);
            qSort(array,left,pivot);
            qSort(array,pivot+1,right);
        }
    }
    /**
     * 递归优化对数组进行快速排序
     */
    public void quickSort2(int[] array){
        if(array.length>1){
            qSort2(array,0,array.length-1);
        }
    }
    /**
     * 尾递归优化对数组子序列进行快速排序
     */
    private void qSort2(int[] array,int left,int right){
        while(left<right){
            int pivot;
            pivot=partition(array,left,right);
            qSort2(array,left,pivot);
            left=pivot+1;
        }
    }
    /**
     * 分区（将较小的数分至左侧，较大的数分至右侧）
     */
    private int partition(int[] array,int left,int right){
        // TODO（可优化） 将枢轴（支点）放至数组第一个元素
        int data=array[left];
        while(left<right){
            while(left<right && array[right]>=data){
                right--;
            }
            array[left]=array[right];//将右侧较小的数替换至左侧
            while(left<right && array[left]<=data){
                left++;
            }
            array[right]=array[left];//将左侧较大的数替换至右侧
        }
        array[left]=data;//将枢轴替换至left位置
        return left;
    }

    public static void main(String[] args) {
        int[] array={9,1,5,8,3,7,4,6,2};
        System.out.println(Arrays.toString(array));
        QuickSort quickSort=new QuickSort();
        quickSort.quickSort(array);
        System.out.println(Arrays.toString(array));
        int[] array2={9,1,5,8,3,7,4,6,2};
        System.out.println(Arrays.toString(array2));
        quickSort.quickSort2(array2);
        System.out.println(Arrays.toString(array2));
    }
}
