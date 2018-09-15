package Date_Structures.Stack;
/**
 * ��������ʵ�ֵ�˳��ջ
 * @param <E>
 */
public class Stack<E> {
    private Object[] data = null;
    private Object e;
    private int maxSize=0;
    private int top=-1;

    /**
     * ���캯�������ݸ�����size��ʼ��ջ
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
            throw new RuntimeException("��ʼ����С����С��0"+initSize);
        }
    }

    //�ж�ջ�Ƿ�Ϊ��
    public boolean isEmpty(){
        return top == -1 ? true : false;
    }

    //Ԫ�ؽ�ջ
    public boolean push(E e){
        if (top == maxSize-1){
            throw new RuntimeException("ջ������Ԫ���޷���ջ��");
        }else{
            data[top++]=e;
            return true;
        }
    }

    //�鿴ջ��Ԫ��
    public Object peek(){
        if(top==-1){
            throw new RuntimeException("ջΪ�գ�");
        }else{
            return data[top];
        }
    }

    //Ԫ�س�ջ
    public Object pop(){
        if(top==-1){
            throw new RuntimeException("ջΪ�գ�");
        }else{
            Object elem=data[top];
            data[top--]=null;
            return elem;
        }
    }

    //���ض����ڶ�ջ�е�λ�ã���1Ϊ����
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
