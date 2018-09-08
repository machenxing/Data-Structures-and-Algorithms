package Date_Structures.Queue;

import java.util.Arrays;

/**
 * ��������ʵ�ֵ�ѭ������
 * @param <E>
 */
public class LoopQueue<E> {
    public Object[] data=null;
    private int maxSize;//��������
    private int rear;//����β����������
    private int front;//����ͷ������ɾ��
    private int size=0;//���е�ǰ����

    //�������
    public LoopQueue(){
        this(10);
    }

    public LoopQueue(int initSize){
        if(initSize>=0){
            this.maxSize=initSize;
            data=new Object[initSize];
            front=rear=0;
        }else{
            throw new RuntimeException("��ʼ����С����С��0��"+initSize);
        }
    }

    //�ж��Ƿ�Ϊ��
    public boolean isEmpty(){
        return size==0;
    }

    //���в���Ԫ��
    public boolean add(E e){
        if(size==maxSize){
            throw new RuntimeException("�����������޷������µ�Ԫ�أ�");
        }else{
            data[rear]=e;
            rear=(rear+1)%maxSize;//��βָ��+1
            size++;
            return true;
        }
    }

    //���ض���Ԫ�أ�������ɾ��
    public E peek(){
        if(isEmpty()){
            throw new RuntimeException("����Ϊ�գ�");
        }else{
            return (E)data[front];
        }
    }

    //����
    public E poll(){
        if(isEmpty()){
            throw new RuntimeException("����Ϊ�գ�");
        }else{
            E elem=(E)data[front];
            data[front]=null;
            front=(front+1)%maxSize;//����ָ��+1
            size--;
            return elem;
        }
    }

    //��ȡ���г���
    public int getLength(){
        return size;
    }

    //��ն���
    public void clean(){
        Arrays.fill(data,null);
        size=0;
        rear=front=0;
    }

}