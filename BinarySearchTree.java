package ADS_Lectures.week4;
class MainBST{
    public static void main(String[] args) {
        BinarySearchTree bts = new BinarySearchTree();
        // task 1 -----------------------
//        bts.insert(3);
//        bts.insert(1);
//        bts.insert(0);
//        bts.insert(2);
//        bts.insert(5);
//        bts.clearTree();
//        bts.inorderDisplay();
        // task 2 -----------------------
        bts.insert(6);
        bts.insert(4);
        bts.insert(9);
        bts.insert(8);
        bts.insert(7);
        bts.insert(2);
        bts.insert(5);
        bts.insert(3);
        bts.insert(1);
        bts.deleteNode(8);
        bts.inorderDisplay();
        System.out.println();
        bts.inorder_rec(bts.searchParent(5));// minus
    }
}
public class BinarySearchTree {
    BinarySearchTree(){}
    Node root;
    public void insert(int data){
        root = insert_rec(root, data);
    }
    private Node insert_rec(Node newRoot, int data){
        if (newRoot == null) {
            newRoot = new Node(data);
        }
        else if (newRoot.val>data){
            newRoot.left = insert_rec(newRoot.left, data);
        }
        else if(newRoot.val<data){
            newRoot.right = insert_rec(newRoot.right, data);
        }
        return newRoot;
    }
    void inorderDisplay(){
        inorder_rec(root);
    }
    void inorder_rec(Node root)
    {
        if (root != null)
        {
            inorder_rec(root.left);
            System.out.print(root.val + " ");
            inorder_rec(root.right);
        }
    }
    public void deleteNode(int elem){
        deleteNode_rec(root, elem);
    }
    public void clearTree(){root=null;}
    Node deleteNode_rec(Node root, int k) {
        if (root == null) return null;
        if (root.val > k) {
            root.left = deleteNode_rec(root.left, k);
        }
        else if (root.val < k) {
            root.right = deleteNode_rec(root.right, k);
        }
        if (root.left == null) {
            return root.right;
        }
        else if (root.right == null) {
            return root.left;
        }
        else {
            Node succParent = root;
            Node succ = root.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }
            if (succParent != root) succParent.left = succ.right;
            else succParent.right = succ.right;
            root.val = succ.val;
        }
        return root;
    }
    public Node searchParent(int data){
        return search_rec(root, data);
    }
    public Node search_rec(Node root, int data)
    {
        if (root==null || root.left.val==data || root.right.val==data) return root;
        if (root.val < data) return search_rec(root.right, data);
        return search_rec(root.left, data);
    }
    class Node{
        int val;
        Node right;
        Node left;
        public Node(int val){
            this.val = val;
            right = null;
            left = null;
        }
    }
}
