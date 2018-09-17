package Date_Structures.Queue;

import java.util.Arrays;

/**
 * 基于数组实现的队列
 * @param <E>
 */
public class Queue<E> {
    private Object[] data=null;
    private int maxSize;
    private int front;
    private int rear;

    //构造函数
    public Queue(){
        this(10);
    }

    public Queue(int initSize){
        if(initSize>=0){
            this.maxSize=initSize;
            data=new Object[initSize];
            front=rear=0;
        }else{
            throw new RuntimeException("初始化大小不能小于："+initSize);
        }
    }

    //判断是否为空
    public boolean isEmpty(){
        return rear==front?true:false;
    }

    //插入队列
    public boolean offer(E e){
        if(rear==maxSize){
            throw new RuntimeException("队列已满，无法插入新的元素！");
        }else{
            data[rear++]=e;
            return true;
        }
    }

    //返回队首元素，但不删除
    public Object peek(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }else{
            return data[front];
        }
    }

    //出队
    public Object poll(){
        if (isEmpty()){
            throw new RuntimeException("队列为空！");
        }else{
            Object elem= data[front];
            data[front++]=null;
            return elem;
        }
    }

    //队列长度
    public int getSize(){
        return rear-front;
    }

    //清空队列
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
