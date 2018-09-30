package Algorithms.Search;

/**
 * 顺序查找
 */
public class SequentialSearch {
    public int sequentialSearch(int[] array, int key){
        if(array.length>0){
            for(int i=0;i<array.length;i++){
                if(array[i]==key)
                    return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array=new int[]{1,3,5,4,6,8,7};
        SequentialSearch sequentialSearch=new SequentialSearch();
        int n=sequentialSearch.sequentialSearch(array,8);
        System.out.println("数8在数组中的第"+n+"个位置");
    }
}
