package Date_Structures.Queue;
/**
 * 基于链式存储结构实现的队列
 * @param <E>
 */
public class LinkQueue<E> {
    //链式队列的节点
    private class Node{
        E e;
        Node next;
        public Node(){
        }
        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }
    }
    private Node front;//队列头，允许插入
    private Node rear;//队列尾，允许插入
    private int size;//队列当前长度

    //构造队列
    public LinkQueue(){
        Node node=new Node(null,null);
        front=node;
        rear=node;
        size=0;
    }

    //判断是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //队列插入元素
    public boolean offer(E e){
        Node elem=new Node(e,null);
        rear.next=elem;
        rear=elem;
        size++;
        return true;
    }

    //返回队首元素，但并不删除
    public E peek(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }else{
            return front.next.e;
        }
    }

    //出队
    public E poll(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }else{
            Node elem=front.next;
            front.next=elem.next;
            elem.next=null;
            size--;
            return elem.e;
        }
    }

    //获取队列长度
    public int getSize(){
        return size;
    }

    //清空队列
    public void clear(){
        for(Node node=front;node!=null;){
            Node next=node.next;
            node.e=null;
            node.next=null;
            node=next;
        }
        size=0;
    }

    public static void main(String[] args) {
        LinkQueue<String> linkQueue=new LinkQueue<>();
        System.out.println("queue is empty:"+linkQueue.isEmpty());
        System.out.println("queue.size="+linkQueue.getSize());
        linkQueue.offer("a");
        linkQueue.offer("b");
        linkQueue.offer("c");
        linkQueue.offer("d");
        linkQueue.offer("e");
        System.out.println("queue is empty:"+linkQueue.isEmpty());
        System.out.println("queue.size="+linkQueue.getSize());
        System.out.println(linkQueue.poll());
        System.out.println(linkQueue.peek());
        System.out.println(linkQueue.poll());
        System.out.println("queue is empty:"+linkQueue.isEmpty());
        System.out.println("queue.size="+linkQueue.getSize());
        linkQueue.clear();
        System.out.println("---------------after clear---------------");
        System.out.println("queue is empty:"+linkQueue.isEmpty());
        System.out.println("queue.size="+linkQueue.getSize());
    }

}
