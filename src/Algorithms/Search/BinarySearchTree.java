package Algorithms.Search;
/**
 * ����������
 */
public class BinarySearchTree {
    BiTreeNode root;
    // �ǵݹ鷽ʽ�����µĽڵ�����
    public boolean insert(int data){
        if(!find(data)){
            BiTreeNode newNode=new BiTreeNode(data);
            if(root==null){
                root=newNode;
            } else {
                BiTreeNode current=root;
                BiTreeNode parent;
                while(true){
                    parent=current;
                    if(data<current.data){
                        current=current.left;
                        if(current==null){
                            parent.left=newNode;
                            return true;
                        }
                    }else{
                        current=current.right;
                        if(current==null){
                            parent.right=newNode;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    //�ǵݹ鷽ʽʵ�ֲ�ѯ
    public boolean find(int data){
        BiTreeNode current=root;
        while(current!=null){
            if(current.data==data){
                return true;
            }else if(data<current.data){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return false;
    }

    //ɾ��ֵΪdata�Ľڵ�
    public boolean remove(int data){
        BiTreeNode dummy=new BiTreeNode(-1);
        dummy.left=root;
        BiTreeNode node;
        BiTreeNode parent=findParent(dummy,root,data);
        if(parent.left!=null && parent.left.data==data){
            node=parent.left;
        }else if(parent.right!=null && parent.right.data==data){
            node=parent.right;
        }else{
            return false;
        }
        delete(parent,node);
        return true;
    }

    //���Ҹ��ڵ�
    private BiTreeNode findParent(BiTreeNode parent,BiTreeNode current,int data){
        if(current==null){
            return parent;
        }else if(current.data==data){
            return parent;
        }else if(current.data>data){
            return findParent(current,current.left,data);
        }else{
            return findParent(current,current.right,data);
        }
    }

    //ɾ���ڵ�
    private void delete(BiTreeNode parent,BiTreeNode current){
        if(current.left==null){
            if(parent.left==current){
                parent.left=current.right;
            }else{
                parent.right=current.right;
            }
        }else if(current.right==null){
            if(parent.left==current){
                parent.left=current.left;
            }else{
                parent.right=current.left;
            }
        }else{
            BiTreeNode father =current;
            BiTreeNode node =current.right;
            while(node.left!=null){     //ת��Ȼ�����ҵ���ͷ���Ҵ�ɾ���ĺ�̣�
                father=node;
                node=node.left;
            }

            if(father.left==node){      //����ɾ���ĺ�̽���
                father.left=node.right;
            }else{
                father.right=node.right;
            }

            if(parent.left==current){
                parent.left=node;
            }else{
                parent.right=node;
            }

            node.left=current.left;
            node.right=current.right;

            if(root==current){      //�������㣬Ҫ�����ڵ�����
                root=node;
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree=new BinarySearchTree();
        binarySearchTree.insert(8);
        binarySearchTree.insert(3);
        System.out.println(binarySearchTree.find(8));
        System.out.println(binarySearchTree.find(3));
        System.out.println(binarySearchTree.root.left.data);
        System.out.println(binarySearchTree.insert(3));
        binarySearchTree.insert(10);
        System.out.println(binarySearchTree.root.right.data);
        binarySearchTree.insert(2);
        binarySearchTree.insert(7);
        System.out.println(binarySearchTree.root.left.right.data);
        binarySearchTree.insert(11);
        binarySearchTree.insert(9);
        System.out.println(binarySearchTree.remove(8));
        System.out.println("is find 8 ?"+binarySearchTree.find(8));
        System.out.println("root is "+binarySearchTree.root.data);
        System.out.println(binarySearchTree.remove(3));
        System.out.println("is find 3 ?"+binarySearchTree.find(3));
        System.out.println("root is "+binarySearchTree.root.left.data);
    }
}
