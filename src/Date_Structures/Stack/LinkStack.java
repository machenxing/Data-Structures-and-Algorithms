package Date_Structures.Stack;
/**
 * ��������ʵ�ֵ�ջ
 * @param <E>
 */
public class LinkStack<E> {
    private class Node{
        E e;
        Node next;
        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }
    }
    private Node top;
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
    public Node peek(){
        if(isEmpty()){
            throw new RuntimeException("ջΪ�գ�");
        }else{
            return top;
        }
    }

    //��ջ
    public Node pop(){
        if (isEmpty()) {
            throw new RuntimeException("ջΪ�գ�");
        }else{
            Node elem=top;
            top =top.next;
            elem.next=null;
            size--;
            return elem;
        }
    }
}
