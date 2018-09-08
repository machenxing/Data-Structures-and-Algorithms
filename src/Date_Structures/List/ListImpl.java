package Date_Structures.List;

import java.util.Arrays;

public class ListImpl implements IList {
    private Object[] data=null;
    private int current;
    private static int length;
    private static final int DefaultSize=10;
    /**
     * 初始化线性表
     */
    @Override
    public void InitList(int initSize) {
        if(initSize<0) {
            throw new RuntimeException("数组大小错误"+initSize);
        }else{
            this.data=new Object[initSize];
            current=0;
            length=initSize;
        }
    }
    /**
     * 删除标号为i的元素
     */
    @Override
    public void ListDelete(int i) throws Exception {
        if(current==0) {
            throw new Exception("当前线性表为空");
        }
        if(i<0||i>length) {
            throw new Exception("输入的数字不合法");
        }else {
//            for(int j=i;j<=current;j++) {
//                data[j]=data[j+1];
                System.arraycopy(data,i+1,data,i,current-i);
//            }
            current --;
        }
    }
    /**
     * 销毁线性表
     */
    @Override
    public void DestroyList() {
        for(int i=0;i<current;i++) {
            this.data[i]=null;
            length=0;
        }
    }
    /**
     * 向线性表中插入数据
     */
    @Override
    public void ListInsert(int i, Object obj) throws Exception {
        if(i<0||i>length) {
            throw new Exception("输入的数字超过线性表的最大长度或不符合规范");
        }else if(current>=length) {
            this.data=new Object[length + DefaultSize];
            length=length+DefaultSize;
        }else {
//            for(int j=current-1;j>=i;j--) {
//                data[j+1]=data[j];
                System.arraycopy(data,i,data,i+1,current-i);
//            }
            this.data[i]=obj;
            current++;
        }
    }

    @Override
    public int Listlength() {
        return this.current;
    }
    /**
     * 清空线性表
     */
    @Override
    public void ClearList() {
        Arrays.fill(data,null);
        current=0;
    }

    @Override
    public boolean Isempty() {
        return this.current==0;
    }
    /**
     * 得到第i个元素
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T getElem(int i) throws Exception {
        if(i<0||i>length) {
            throw new Exception("输入的数字不合法");
        }else {
            return (T) this.data[i];
        }
    }

    public static void main(String[] args)throws Exception {
        ListImpl list=new ListImpl();
        list.InitList(10);
        list.ListInsert(0,2);
        list.ListInsert(1,"a");
        list.ListInsert(2,"b");
        list.ListInsert(2,"bfd");
        Object li=list.getElem(2);
        System.out.println("Di:"+li);
        System.out.println("第二个元素是:"+list.getElem(2));
        for(int i=0;i<length;i++) {
            System.out.print(i+":"+list.data[i]+" ");
        }
        list.ListDelete(2);
        System.out.println("删除后：");
        for(int i=0;i<length;i++) {
            System.out.print(i+":"+list.data[i]+" ");
        }
    }
}
