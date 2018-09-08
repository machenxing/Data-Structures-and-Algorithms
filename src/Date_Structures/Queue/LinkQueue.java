package Date_Structures.Queue;
/**
 * 基于链式存储结构实现的队列
 * @param <E>
 */
public class LinkQueue<E> {
    //链式队列的节点
    private class Node<E>{
        E e;
        Node<E> next;
        public Node(){
        }
        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }
    }
    private Node<E> front;//队列头，允许插入
    private Node<E> rear;//队列尾，允许插入
    private int size;//队列当前长度

    //构造队列
    public LinkQueue(){
        front=null;
        rear=null;
        size=0;
    }

    //判断是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //队列插入元素
    public boolean add(E e){
        Node<E> elem=new Node(e,null);
        rear.next=elem;
        rear=elem;
        size++;
        return true;
    }

    //返回队首元素，但并不删除
    public Node<E> peek(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }else{
            return front;
        }
    }

    //出队
    public Node<E> pool(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }else{
            Node<E> elem=front;
            elem.next=null;
            front=front.next;
            size--;
            return elem;
        }
    }

    //获取队列长度
    public int getLength(){
        return size;
    }

}
