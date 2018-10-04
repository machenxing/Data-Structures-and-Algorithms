package Algorithms.Sort;

import java.util.Arrays;

/**
 * ��������
 */
public class QuickSort {
    /**
     * ��������п�������
     */
    public void quickSort(int[] array){
        if(array.length>1){
            qSort(array,0,array.length-1);
        }
    }
    /**
     * ���õݹ�����������н��п�������
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
     * �ݹ��Ż���������п�������
     */
    public void quickSort2(int[] array){
        if(array.length>1){
            qSort2(array,0,array.length-1);
        }
    }
    /**
     * β�ݹ��Ż������������н��п�������
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
     * ����������С����������࣬�ϴ���������Ҳࣩ
     */
    private int partition(int[] array,int left,int right){
        // TODO�����Ż��� �����ᣨ֧�㣩���������һ��Ԫ��
        int data=array[left];
        while(left<right){
            while(left<right && array[right]>=data){
                right--;
            }
            array[left]=array[right];//���Ҳ��С�����滻�����
            while(left<right && array[left]<=data){
                left++;
            }
            array[right]=array[left];//�����ϴ�����滻���Ҳ�
        }
        array[left]=data;//�������滻��leftλ��
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
