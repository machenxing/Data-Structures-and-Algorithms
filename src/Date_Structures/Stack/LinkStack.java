package Date_Structures.Stack;
/**
 * ��������ʵ�ֵ�ջ
 * @param <E>
 */
public class LinkStack<E> {
    private class Node<E>{
        E e;
        Node<E> next;
        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }
    }
    private Node<E> top;
    private int size;

    public LinkStack(){
        top=null;
    }

    //��ǰջ��С
    public int length(){
        return size;
    }

    //�ж��Ƿ�Ϊ��
    public boolean isEmpty(){
        return size==0;
    }

    //��ջ
    public boolean push(E e){
        top = new Node(e,top);
        size++;
        return true;
    }

    //�鿴ջ��Ԫ�ص���ɾ��
    public Node<E> peek(){
        if(isEmpty()){
            throw new RuntimeException("ջΪ�գ�");
        }else{
            return top;
        }
    }

    //��ջ
    public Node<E> pop(){
        if (isEmpty()) {
            throw new RuntimeException("ջΪ�գ�");
        }else{
            Node<E> elem=top;
            top =top.next;
            elem.next=null;
            size--;
            return elem;
        }
    }
}
