package Date_Structures.Stack;

import java.util.Arrays;

/**
 * 基于数组实现的顺序栈
 * @param <E>
 */
public class Stack<E> {
    private Object[] data = null;
    private Object e;
    private int maxSize=0;
    private int top=-1;

    /**
     * 构造函数：根据给定的size初始化栈
     */
    Stack(){
        this(10);
    }

    public Stack(int initSize){
        if(initSize>=0){
            this.maxSize=initSize;
            data = new Object[initSize];
            top=-1;
        }else{
            throw new RuntimeException("初始化大小不能小于0"+initSize);
        }
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return top == -1 ? true : false;
    }

    //元素进栈
    public boolean push(E e){
        if (top == maxSize-1){
            throw new RuntimeException("栈已满，元素无法入栈！");
        }else{
            data[++top]=e;
            return true;
        }
    }

    //查看栈顶元素
    public Object peek(){
        if(top==-1){
            throw new RuntimeException("栈为空！");
        }else{
            return data[top];
        }
    }

    //元素出栈
    public Object pop(){
        if(top==-1){
            throw new RuntimeException("栈为空！");
        }else{
            Object elem=data[top];
            data[top--]=null;
            return elem;
        }
    }

    //返回对象在堆栈中的位置，以1为基数
    public int search(E e){
        int i=top;
        while(top!=-1){
            if(peek()!=e){
                top--;
            }else{
                break;
            }
        }
        int result = top+1;
        top=i;
        return result;
    }
    //查看栈的大小
    public int getSize(){
        return top+1;
    }

    //清空栈
    public void clear(){
        Arrays.fill(data,null);
        top=-1;
    }

    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        System.out.println("stack.maxSize="+stack.maxSize);
        System.out.println("stack.size="+stack.getSize());
        System.out.println("stack is empty?"+stack.isEmpty());
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        System.out.println("stack.size="+stack.getSize());
        System.out.println("stack is empty?"+stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println("stack.size="+stack.getSize());
        System.out.println("stack is empty?"+stack.isEmpty());
        stack.clear();
        System.out.println("---------------after clear---------------");
        System.out.println("queue is empty?"+stack.isEmpty());
        System.out.println("queue.size="+stack.getSize());
    }

}
