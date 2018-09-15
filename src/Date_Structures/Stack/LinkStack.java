package Date_Structures.Stack;
/**
 * 基于链表实现的栈
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

    //当前栈大小
    public int length(){
        return size;
    }

    //判断是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //入栈
    public boolean push(E e){
        top = new Node(e,top);
        size++;
        return true;
    }

    //查看栈顶元素但不删除
    public Node peek(){
        if(isEmpty()){
            throw new RuntimeException("栈为空！");
        }else{
            return top;
        }
    }

    //出栈
    public Node pop(){
        if (isEmpty()) {
            throw new RuntimeException("栈为空！");
        }else{
            Node elem=top;
            top =top.next;
            elem.next=null;
            size--;
            return elem;
        }
    }
}
