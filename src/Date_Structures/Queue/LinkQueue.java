package Date_Structures.Queue;
/**
 * ������ʽ�洢�ṹʵ�ֵĶ���
 * @param <E>
 */
public class LinkQueue<E> {
    //��ʽ���еĽڵ�
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
    private Node front;//����ͷ���������
    private Node rear;//����β���������
    private int size;//���е�ǰ����

    //�������
    public LinkQueue(){
        Node node=new Node(null,null);
        front=node;
        rear=node;
        size=0;
    }

    //�ж��Ƿ�Ϊ��
    public boolean isEmpty(){
        return size==0;
    }

    //���в���Ԫ��
    public boolean offer(E e){
        Node elem=new Node(e,null);
        rear.next=elem;
        rear=elem;
        size++;
        return true;
    }

    //���ض���Ԫ�أ�������ɾ��
    public E peek(){
        if(isEmpty()){
            throw new RuntimeException("����Ϊ�գ�");
        }else{
            return front.next.e;
        }
    }

    //����
    public E poll(){
        if(isEmpty()){
            throw new RuntimeException("����Ϊ�գ�");
        }else{
            Node elem=front.next;
            front.next=elem.next;
            elem.next=null;
            size--;
            return elem.e;
        }
    }

    //��ȡ���г���
    public int getSize(){
        return size;
    }

    //��ն���
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
