package Algorithms.Search;

public class BalancedBinaryTree extends BinarySearchTree {
    /**
     * �жϽ���Ƿ�ƽ��
     */
    public boolean isBalanced (BiTreeNode node){
        return maxDepth(node)!=-1;
    }
    /**
     * �����������
     * ���ý�㲻ƽ�⣬�����Ϊ-1
     */
    private int maxDepth(BiTreeNode node){
        if(node==null){
            return 0;
        }
        int left=maxDepth(node.left);
        int right=maxDepth(node.right);
        //������������������ƽ�⣬����߶Ȳ����1,��ý�㲻ƽ��
        if(left==-1||right==-1||Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        BalancedBinaryTree tree=new BalancedBinaryTree();
        tree.insert(8);
        tree.insert(3);
        tree.insert(10);
        tree.insert(12);
        System.out.println(tree.isBalanced(tree.root));
        tree.insert(15);
        System.out.println(tree.isBalanced(tree.root));
    }
}
