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
    public boolean offer(E e){
        if(rear==maxSize){
            throw new RuntimeException("�����������޷������µ�Ԫ�أ�");
        }else{
            data[rear++]=e;
            return true;
        }
    }

    //���ض���Ԫ�أ�����ɾ��
    public Object peek(){
        if(isEmpty()){
            throw new RuntimeException("����Ϊ�գ�");
        }else{
            return data[front];
        }
    }

    //����
    public Object poll(){
        if (isEmpty()){
            throw new RuntimeException("����Ϊ�գ�");
        }else{
            Object elem= data[front];
            data[front++]=null;
            return elem;
        }
    }

    //���г���
    public int getSize(){
        return rear-front;
    }

    //��ն���
    public void clear(){
        Arrays.fill(data,null);
        rear=front=0;
    }

    public static void main(String[] args) {
        Queue<String> queue=new Queue<>();
        System.out.println("queue is empty:"+queue.isEmpty());
        System.out.println("queue.size="+queue.getSize());
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        System.out.println("queue is empty:"+queue.isEmpty());
        System.out.println("queue.size="+queue.getSize());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println("queue is empty:"+queue.isEmpty());
        System.out.println("queue.size="+queue.getSize());
        queue.clear();
        System.out.println("---------------after clear---------------");
        System.out.println("queue is empty:"+queue.isEmpty());
        System.out.println("queue.size="+queue.getSize());
    }

}
