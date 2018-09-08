package Date_Structures.List;

import java.util.Arrays;

public class ListImpl implements IList {
    private Object[] data=null;
    private int current;
    private static int length;
    private static final int DefaultSize=10;
    /**
     * ��ʼ�����Ա�
     */
    @Override
    public void InitList(int initSize) {
        if(initSize<0) {
            throw new RuntimeException("�����С����"+initSize);
        }else{
            this.data=new Object[initSize];
            current=0;
            length=initSize;
        }
    }
    /**
     * ɾ�����Ϊi��Ԫ��
     */
    @Override
    public void ListDelete(int i) throws Exception {
        if(current==0) {
            throw new Exception("��ǰ���Ա�Ϊ��");
        }
        if(i<0||i>length) {
            throw new Exception("��������ֲ��Ϸ�");
        }else {
//            for(int j=i;j<=current;j++) {
//                data[j]=data[j+1];
                System.arraycopy(data,i+1,data,i,current-i);
//            }
            current --;
        }
    }
    /**
     * �������Ա�
     */
    @Override
    public void DestroyList() {
        for(int i=0;i<current;i++) {
            this.data[i]=null;
            length=0;
        }
    }
    /**
     * �����Ա��в�������
     */
    @Override
    public void ListInsert(int i, Object obj) throws Exception {
        if(i<0||i>length) {
            throw new Exception("��������ֳ������Ա����󳤶Ȼ򲻷��Ϲ淶");
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
     * ������Ա�
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
     * �õ���i��Ԫ��
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T getElem(int i) throws Exception {
        if(i<0||i>length) {
            throw new Exception("��������ֲ��Ϸ�");
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
        System.out.println("�ڶ���Ԫ����:"+list.getElem(2));
        for(int i=0;i<length;i++) {
            System.out.print(i+":"+list.data[i]+" ");
        }
        list.ListDelete(2);
        System.out.println("ɾ����");
        for(int i=0;i<length;i++) {
            System.out.print(i+":"+list.data[i]+" ");
        }
    }
}
