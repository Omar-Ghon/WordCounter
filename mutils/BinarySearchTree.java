package mutils;

public class BinarySearchTree {
    public Node root;
    public BinarySearchTree() {
        this.root = null;
    }
    public void insert(Node new_node) {
        this.root = insert(root, new_node);
    }

    public Node insert(Node root, Node new_node) {
        if (root == null) {
            root = new_node;
            return root;
        }
        else if (root.compareTo(new_node) > 0) {
            root.left = insert(root.left, new_node);
        } else {
            root.right = insert(root.right, new_node);
        }
        return root;
    }

    //Traversal
    public void inorder() {
        inorder(root);
    }

    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    /*
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(new Node("abef", 1));
        bst.insert(new Node("abd", 1));
        bst.insert(new Node("abee", 1));
        bst.insert(new Node("f", 1));
        bst.insert(new Node("a", 1));
        bst.insert(new Node("bce", 1));
        bst.inorder();
    }*/
}