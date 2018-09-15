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
        front=null;
        rear=null;
        size=0;
    }

    //�ж��Ƿ�Ϊ��
    public boolean isEmpty(){
        return size==0;
    }

    //���в���Ԫ��
    public boolean add(E e){
        Node elem=new Node(e,null);
        rear.next=elem;
        rear=elem;
        size++;
        return true;
    }

    //���ض���Ԫ�أ�������ɾ��
    public Node peek(){
        if(isEmpty()){
            throw new RuntimeException("����Ϊ�գ�");
        }else{
            return front;
        }
    }

    //����
    public Node pool(){
        if(isEmpty()){
            throw new RuntimeException("����Ϊ�գ�");
        }else{
            Node elem=front;
            elem.next=null;
            front=front.next;
            size--;
            return elem;
        }
    }

    //��ȡ���г���
    public int getLength(){
        return size;
    }

}
