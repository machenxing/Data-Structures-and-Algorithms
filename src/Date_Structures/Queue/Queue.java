package Date_Structures.Queue;

import java.util.Arrays;

/**
 * ��������ʵ�ֵĶ���
 * @param <E>
 */
public class Queue<E> {
    private Object[] data=null;
    private int maxSize;
    private int front;
    private int rear;

    //���캯��
    public Queue(){
        this(10);
    }

    public Queue(int initSize){
        if(initSize>=0){
            this.maxSize=initSize;
            data=new Object[initSize];
            front=rear=0;
        }else{
            throw new RuntimeException("��ʼ����С����С�ڣ�"+initSize);
        }
    }

    //�ж��Ƿ�Ϊ��
    public boolean isEmpty(){
        return rear==front?true:false;
    }

    //�������
    public boolean add(E e){
        if(rear==maxSize){
            throw new RuntimeException("�����������޷������µ�Ԫ�أ�");
        }else{
            data[rear++]=e;
            return true;
        }
    }

    //���ض���Ԫ�أ�����ɾ��
    public E peek(){
        if(isEmpty()){
            throw new RuntimeException("����Ϊ�գ�");
        }else{
            return (E) data[front];
        }
    }

    //����
    public E poll(){
        if (isEmpty()){
            throw new RuntimeException("����Ϊ�գ�");
        }else{
            E elem=(E) data[front];
            data[front++]=null;
            return elem;
        }
    }

    //���г���
    public int getLength(){
        return rear-front;
    }

    //��ն���
    public void clean(){
        Arrays.fill(data,null);
        rear=front=0;
    }

}
