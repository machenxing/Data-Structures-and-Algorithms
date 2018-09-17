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
    public int getSize(){
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
    public E peek(){
        if(isEmpty()){
            throw new RuntimeException("栈为空！");
        }else{
            return top.e;
        }
    }

    //出栈
    public E pop(){
        if (isEmpty()) {
            throw new RuntimeException("栈为空！");
        }else{
            Node elem=top;
            top =top.next;
            elem.next=null;
            size--;
            return elem.e;
        }
    }

    //清空栈
    public void clear(){
        for(Node node=top;node!=null;){
            Node next=node.next;
            node.e=null;
            node.next=null;
            node=next;
        }
        size=0;
    }

    public static void main(String[] args) {
        LinkStack<String> linkStack=new LinkStack<>();
        System.out.println("linkStack.size = "+linkStack.getSize());
        System.out.println("stack is empty?"+linkStack.isEmpty());
        linkStack.push("a");
        linkStack.push("b");
        linkStack.push("c");
        linkStack.push("d");
        linkStack.push("e");
        System.out.println("stack.size="+linkStack.getSize());
        System.out.println("stack is empty?"+linkStack.isEmpty());
        System.out.println(linkStack.pop());
        System.out.println(linkStack.peek());
        System.out.println(linkStack.pop());
        System.out.println("stack.size="+linkStack.getSize());
        System.out.println("stack is empty?"+linkStack.isEmpty());
        linkStack.clear();
        System.out.println("------------after clear-------------");
        System.out.println("stack.size="+linkStack.getSize());
        System.out.println("stack is empty?"+linkStack.isEmpty());
    }
}
