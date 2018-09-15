package Date_Structures.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ����ֵΪint������
 */
public class BinaryTree {
    private int val;
    private BinaryTree left;
    private BinaryTree right;
    public BinaryTree(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }

    /**
     * ǰ�����������
     * ��ʽһ���ݹ�
     */
    public ArrayList<Integer> preOrderTraversal(BinaryTree root){
        ArrayList<Integer> preOrder=new ArrayList<>();
        preTraverse(root,preOrder);
        return preOrder;
    }
    private void preTraverse(BinaryTree root, List<Integer> preOrder){
        if(root==null){
            return;
        }
        preOrder.add(root.val);
        preTraverse(root.left,preOrder);
        preTraverse(root.right,preOrder);
    }

    /**
     * ǰ�����������
     * ��ʽ��������˼��
     */
    public ArrayList<Integer> preOrderTraversal2(BinaryTree root){
        ArrayList<Integer> preOrder = new ArrayList<>();
        if (root==null){
            return preOrder;
        }
        ArrayList<Integer> left=preOrderTraversal(root.left);
        ArrayList<Integer> right=preOrderTraversal(root.right);
        preOrder.add(root.val);
        preOrder.addAll(left);
        preOrder.addAll(right);
        return preOrder;
    }
    /**
     * �������������
     * ��ʽһ���ݹ�
     */
    public ArrayList<Integer> inOrderTraversal(BinaryTree root){
        ArrayList<Integer> inOrder=new ArrayList<>();
        inOrderTraverse(root,inOrder);
        return inOrder;
    }
    private void inOrderTraverse(BinaryTree root,List<Integer> inOrder){
        if(root==null){
            return;
        }
        inOrderTraverse(root.left,inOrder);
        inOrder.add(root.val);
        inOrderTraverse(root.right,inOrder);
    }
    /**
     * �������������
     * ��ʽ��������˼��
     */
    public ArrayList<Integer> inOrderTraverse2(BinaryTree root){
        ArrayList<Integer> inOrder=new ArrayList<>();
        if (root==null){
            return inOrder;
        }
        ArrayList<Integer> left=inOrderTraversal(root.left);
        ArrayList<Integer> right=inOrderTraversal(root.right);
        inOrder.addAll(left);
        inOrder.add(root.val);
        inOrder.addAll(right);
        return inOrder;
    }
    /**
     * �������������
     * ��ʽһ���ݹ�
     */
    public ArrayList<Integer> postOrderTraverse(BinaryTree root){
        ArrayList<Integer> postOrder=new ArrayList<>();
        postOrderTraverse(root,postOrder);
        return postOrder;
    }
    private void postOrderTraverse(BinaryTree root,List<Integer> postOrder){
        if(root==null){
            return;
        }
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        postOrder.add(root.val);
    }
    /**
     * �������������
     * ��ʽ��������˼��
     */
    public ArrayList<Integer> postOrderTraverse2(BinaryTree root){
        ArrayList<Integer> postOrder=new ArrayList<>();
        if(root==null){
            return postOrder;
        }
        ArrayList<Integer> left=postOrderTraverse(root.left);
        ArrayList<Integer> right=postOrderTraverse(root.right);
        postOrder.addAll(left);
        postOrder.addAll(right);
        postOrder.add(root.val);
        return postOrder;
    }
    /**
     * �������
     * ʹ�ö���˼��
     */
    public ArrayList<Integer> levelOrderTraversal(BinaryTree root){
        ArrayList<Integer> result =new ArrayList<>();
        Queue<BinaryTree> queue = new LinkedList<>();
        if(root!=null){
            result.add(root.val);
            queue.offer(root);
            while(queue.size()>0){
                BinaryTree node=queue.poll();
                if(node.left!=null){
                    result.add(node.left.val);
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    result.add(node.right.val);
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }
}
