package Algorithms.Search;

/**
 * 折半查找||二分查找
 */
public class BinarySearch {
    /**
     * 非递归实现
     */
    public int binarySearch(int[] array, int key){
        if(array.length>0){
            int low=0;
            int high=array.length-1;
            int mid;
            while(low<=high){
                mid=(low+high)/2;
                if(key<array[mid]){
                    high=mid-1;     //最高下标调整到中位下标小1位
                }else if(key>array[mid]){
                    low=mid+1;      //最低下标调整到中位下标大1位
                }
                else{
                    return mid+1;
                }
            }
        }

        return -1;
    }
    /**
     * 递归实现
     */
    public int binarySearch2(int[] array,int key,int low,int high){
        if(low<=high){
            int mid=(low+high)/2;
            if(key<array[mid]){
                return binarySearch2(array,key,low,mid-1);
            }else if(key>array[mid]){
                return binarySearch2(array,key,mid+1,high);
            }else{
                return mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array=new int[]{1,3,5,9,11,15};
        BinarySearch binarySearch=new BinarySearch();
        System.out.println("---------非递归实现二分查找----------");
        int n=binarySearch.binarySearch(array,11);
        System.out.println("数11在数组中的第"+n+"个位置");
        System.out.println("---------递归实现二分查找----------");
        int m=binarySearch.binarySearch2(array,11,0,array.length-1);
        System.out.println("数11在数组中的第"+m+"个位置");
    }
}
