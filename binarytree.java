import java.util.*;

public class binarytree{
public static void main (String [] args){
    binarytreee tree =  new binarytreee();
 Scanner sc = new Scanner (System.in);

    while (a < 19){

        tree.addNode(sc.nextInt());
    }

    int count = 0;

    System.out.println(tree.findMaxDepth(tree.root));
}
}


class binarytreee {
    
    Node root; // every tree will have a root value

    public void addNode(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
        } else {
            addNodeRecursive(root, newNode);
        }
    }
    
    private void addNodeRecursive(Node current, Node newNode) {
        if (newNode.key < current.key) {
            if (current.leftChild == null) {
                current.leftChild = newNode;
            } else {
                addNodeRecursive(current.leftChild, newNode);
            }
        } else {
            if (current.rightChild == null) {
                current.rightChild = newNode;
            } else {
                addNodeRecursive(current.rightChild, newNode);
            }
        }
    }
    

    public void inOrderTraverse(Node focusNode){
        if (focusNode != null){
            inOrderTraverse(focusNode.leftChild);
            System.out.print(focusNode);
            inOrderTraverse(focusNode.rightChild);
        }
    }
    public int findMaxDepth(Node node) {
        if (node == null) {
            return 0; // Base case: the depth of an empty tree is 0.
        }
        int leftDepth = findMaxDepth(node.leftChild); // Depth of left subtree
        int rightDepth = findMaxDepth(node.rightChild); // Depth of right subtree
        return Math.max(leftDepth, rightDepth) + 1; // Return the greater of the two depths plus one for the root
    }
    public static int makeIntoArray(Node tree, int [] array, int i){
        
    }

    public void preOrderTraverse(Node focusNode){
        if (focusNode != null){
            System.out.print(focusNode);
            preOrderTraverse(focusNode.leftChild);  
            preOrderTraverse(focusNode.rightChild);
        }
    }
    public void postOrderTraverse(Node focusNode){
        if (focusNode != null){
            postOrderTraverse(focusNode.leftChild);  
            postOrderTraverse(focusNode.rightChild);
            System.out.print(focusNode);
        }
    }

    public Node findNode(int key) {
        Node focusNode = root;
        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;  
            }
    
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;  // Returns the node when found
    }

     // Method to delete a node with the specified key
     public void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    // Recursive method to perform deletion
    private Node deleteRec(Node focusNode, int key) {
        // Base case: If the tree is empty
        if (focusNode == null) return focusNode;

        // Otherwise, traverse the tree
        if (key < focusNode.key) {
            // If the key to be deleted is smaller than the focusNode's key,
            // it lies in the left subtree
            focusNode.leftChild = deleteRec(focusNode.leftChild, key);
        } else if (key > focusNode.key) {
            // If the key to be deleted is greater than the focusNode's key,
            // it lies in the right subtree
            focusNode.rightChild = deleteRec(focusNode.rightChild, key);
        } else {
            // This is the node to be deleted

            // Case 1: No child or one child
            if (focusNode.leftChild == null)
                return focusNode.rightChild;
            else if (focusNode.rightChild == null)
                return focusNode.leftChild;

            // Case 2: Two children, get the inorder successor (smallest in the right subtree)
            focusNode.key = minValue(focusNode.rightChild);

            // Delete the inorder successor
            focusNode.rightChild = deleteRec(focusNode.rightChild, focusNode.key);
        }

        return focusNode;
    }

    // Method to find the minimum value (key) in the tree
    private int minValue(Node focusNode) {
        int minv = focusNode.key;
        while (focusNode.leftChild != null) {
            minv = focusNode.leftChild.key;
            focusNode = focusNode.leftChild;
        }
        return minv;
    

    }
  


}







class Node{

    int key;

    Node leftChild;
    Node rightChild;

    Node(int key){
        this.key = key;
    }
}