package Date_Structures.Queue;

import java.util.Arrays;

/**
 * 基于数组实现的循环队列
 * @param <E>
 */
public class LoopQueue<E> {
    public Object[] data=null;
    private int maxSize;//队列容量
    private int rear;//队列尾，允许插入
    private int front;//队列头，允许删除
    private int size=0;//队列当前长度

    //构造队列
    public LoopQueue(){
        this(10);
    }

    public LoopQueue(int initSize){
        if(initSize>=0){
            this.maxSize=initSize;
            data=new Object[initSize];
            front=rear=0;
        }else{
            throw new RuntimeException("初始化大小不能小于0："+initSize);
        }
    }

    //判断是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //队列插入元素
    public boolean offer(E e){
        if(size==maxSize){
            throw new RuntimeException("队列已满，无法插入新的元素！");
        }else{
            data[rear]=e;
            rear=(rear+1)%maxSize;//队尾指针+1
            size++;
            return true;
        }
    }

    //返回队首元素，但并不删除
    public Object peek(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }else{
            return data[front];
        }
    }

    //出队
    public Object poll(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }else{
            Object elem=data[front];
            data[front]=null;
            front=(front+1)%maxSize;//队首指针+1
            size--;
            return elem;
        }
    }

    //获取队列长度
    public int getSize(){
        return size;
    }

    //清空队列
    public void clear(){
        Arrays.fill(data,null);
        size=0;
        rear=front=0;
    }

    public static void main(String[] args) {
        LoopQueue<String> loopQueue=new LoopQueue<>();
        System.out.println("queue is empty:"+loopQueue.isEmpty());
        System.out.println("queue.size="+loopQueue.getSize());
        loopQueue.offer("a");
        loopQueue.offer("b");
        loopQueue.offer("c");
        loopQueue.offer("d");
        loopQueue.offer("e");
        System.out.println("queue is empty:"+loopQueue.isEmpty());
        System.out.println("queue.size="+loopQueue.getSize());
        System.out.println(loopQueue.poll());
        System.out.println(loopQueue.peek());
        System.out.println(loopQueue.poll());
        System.out.println("queue is empty:"+loopQueue.isEmpty());
        System.out.println("queue.size="+loopQueue.getSize());
        loopQueue.clear();
        System.out.println("---------------after clear---------------");
        System.out.println("queue is empty:"+loopQueue.isEmpty());
        System.out.println("queue.size="+loopQueue.getSize());
    }

}
