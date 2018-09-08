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
    public boolean add(E e){
        if(rear==maxSize){
            throw new RuntimeException("队列已满，无法插入新的元素！");
        }else{
            data[rear++]=e;
            return true;
        }
    }

    //返回队首元素，但不删除
    public E peek(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }else{
            return (E) data[front];
        }
    }

    //出队
    public E poll(){
        if (isEmpty()){
            throw new RuntimeException("队列为空！");
        }else{
            E elem=(E) data[front];
            data[front++]=null;
            return elem;
        }
    }

    //队列长度
    public int getLength(){
        return rear-front;
    }

    //清空队列
    public void clean(){
        Arrays.fill(data,null);
        rear=front=0;
    }

}
