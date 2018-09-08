package Date_Structures.Stack;
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

    Stack(int initSize){
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
            data[top++]=e;
            return true;
        }
    }

    //查看栈顶元素
    public E peek(){
        if(top==-1){
            throw new RuntimeException("栈为空！");
        }else{
            return (E)data[top];
        }
    }

    //元素出栈
    public E pop(){
        if(top==-1){
            throw new RuntimeException("栈为空！");
        }else{
            return (E)data[top--];
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

}
