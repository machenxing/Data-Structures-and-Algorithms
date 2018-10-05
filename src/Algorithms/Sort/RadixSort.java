package Algorithms.Sort;

import java.util.Arrays;
/**
 * ��������
 */
public class RadixSort {
    /**
     * LSDʵ�ֻ�������
     */
    public void radixSortLSD(int [] array,int radix,int digit){
        if(array.length>1){
            int num[]=new int[array.length];
            int buckets[]=new int[radix];//����Ͱ������
            int rate=1;
            for(int i=0;i<=digit;i++){
                Arrays.fill(buckets,0);
                System.arraycopy(array,0,num,0,array.length);//������Ԫ�ظ��Ƶ���ʱ����num��
                /**
                 * �������Ͱ������
                 */
                for(int j=0;j<array.length;j++){
                    int subKey=(array[j]/rate)%radix;
                    buckets[subKey]++;
                }
                /**
                 * ����Ͱ��Ԫ����������Ӧ�������λ��
                 */
                for(int j=1;j<radix;j++){
                    buckets[j]=buckets[j]+buckets[j-1];
                }
                /**
                 * ������Ԫ�ذ���������������
                 */
                for(int k=array.length-1;k>=0;k--){
                    int subKey =(num[k]/rate)%radix;
                    array[--buckets[subKey]]=num[k];
                }
                rate*=radix;
            }
        }
    }
    /**
     * MSDʵ�ֻ�������
     */
    public void radixSortMSD(int [] array,int left,int right,int radix,int digit){
        if(right>left){
            int num[]=new int[right-left+1];
            int buckets[]=new int[radix];//����Ͱ������
            int rate=(int)Math.pow(radix,digit-1);
            Arrays.fill(buckets,0);
            System.arraycopy(array,left,num,0,right-left+1);//������Ԫ�ظ��Ƶ���ʱ����num��
            /**
             * �������Ͱ������
             */
            for(int j=left;j<=right;j++){
                int subKey=(array[j]/rate)%radix;
                buckets[subKey]++;
            }
            /**
             * ����Ͱ��Ԫ����������Ӧ�������λ��
             */
            for(int j=1;j<radix;j++){
                buckets[j]=buckets[j]+buckets[j-1];
            }
            /**
             * ������Ԫ�ذ����̵�������������
             */
            for(int k=num.length-1;k>=0;k--){
                int subKey =(num[k]/rate)%radix;
                array[left+(--buckets[subKey])]=num[k];
            }
            if(digit>0){
                int subKey;
                radixSortMSD(array,left,left+buckets[0]-1,radix,digit-1);
                for(subKey=0;subKey<radix-1;subKey++){
                    radixSortMSD(array,left+buckets[subKey],left+buckets[subKey+1]-1,radix,digit-1);
                }
                radixSortMSD(array,left+buckets[subKey],right,radix,digit-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] array={20, 80, 90, 589, 998, 965, 852, 123, 456, 789};
        System.out.println(Arrays.toString(array));
        RadixSort radixSort=new RadixSort();
        radixSort.radixSortLSD(array,10,3);
        System.out.println(Arrays.toString(array));
        int[] array2={200, 1, 3, 42, 9, 64, 7, 81, 5, 10, 52, 61};
        System.out.println(Arrays.toString(array2));
        radixSort.radixSortMSD(array2,0,array2.length-1,10,3);
        System.out.println(Arrays.toString(array2));
    }

}
