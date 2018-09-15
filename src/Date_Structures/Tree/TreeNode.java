package Date_Structures.Tree;
/**
 * 定义二叉链表
 */
public class TreeNode<E> {
    private E val;
    private TreeNode<E> left;
    private TreeNode<E> right;
    public TreeNode(E val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}
