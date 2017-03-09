import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class wd {
    public static void main(String[] args) {
        Tree<Integer> tree=new Tree<>();
        Arrays.asList(3,1,2,5,4).forEach(tree::insert);
        //System.out.println(tree.root);
        tree.inorder(tree.root);
        tree.breadfirst();
        System.out.println("depth:"+tree.depth(tree.root));
    }

}

 class Tree<T extends  Comparable<T>> {
    Node<T> root=null;
    public  void insert(T data){
        Node<T> p=root,prev=null;
        while (p!=null){
            prev=p;
            p= p.value.compareTo(data)>0? p.left:p.right;
        }
        if(root==null)
            root=new Node<>(data);
        else  if(prev.value.compareTo(data)>0)
            prev.left=new Node<>(data);
        else
            prev.right=new Node<>(data);

    }
    public  void preorder(Node<T> p){
        if(p!=null){
            System.out.println(p.value);
            preorder(p.left);
            preorder(p.right);
        }
    }
     public  void inorder(Node<T> p){
         if(p!=null){
             inorder(p.left);
             System.out.println(p.value);
             inorder(p.right);
         }
     }
     public void breadfirst(){
         Node<T> p=root;
         ArrayDeque<Node<T>>queuq=new ArrayDeque<>();
         if(p!=null){
             queuq.offer(p);
             while (!queuq.isEmpty()){
                 p=queuq.poll();
                 System.out.println(p.value);
                 if(p.left!=null)
                     queuq.offer(p.left);
                 if(p.right!=null)
                     queuq.offer(p.right);
             }
         }
    }
     public Node<T> search(Node<T>root,T data){
         while (root!=null){
             if(root.value.compareTo(data)==0)
                 return  root;
             else if(root.value.compareTo(data)>0)
                 root=root.left;
             else  root=root.right;
         }
         return  null;
     }
     public  void interativePreorder(){
         Node<T> p=root;
         Stack<Node<T>> stack=new Stack<>();
         if(p!=null){
             while (!stack.isEmpty())
            p=stack.pop();
             System.out.println(p.value);
             if(p.right!=null)
                 stack.push(p.right);
             if(p.left!=null)
                 stack.push(p.left);
         }
     }
     public int depth(Node<T> node){
         int m,n;
         if(node==null) return  0;
         else {
             m=depth(node.left);
             n=depth(node.right);
             return  (m>n?m:n)+1;
         }

     }

}







class Node<T extends  Comparable<T>> {
    T value;
    Node<T> left;
    Node<T> right;

    public Node() {

    }

    public Node(T data) {
        value = data;
    }

    public Node(T data, Node<T> lchild, Node<T> rchild) {
        value = data;
        left = lchild;
        right = rchild;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }
}



