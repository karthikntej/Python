import java.util.LinkedList;
import java.util.Queue;


class Node {
    int value;
    Node left, right;

    Node (int kay) {
        value = kay;
        left = right = null;
    }
}

class BinaryTree {
    Node root;
    static int max = 0;
    
    BinaryTree() {
        root = null;
    }

    BinaryTree(int val){
        root = new Node(val);
    }

    public void traverse(Node i) {
        if (i != null) {
        
            if (i.left != null)
            traverse(i.left);
        
            System.out.print (i.value + " ");
            
            if (i.right != null)
            traverse(i.right);
        }
    }
    
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        
        Node i;
        while (queue.peek() != null) {
            i = queue.remove();
            System.out.print (i.value + " ");
            if (i.left != null)
                queue.add(i.left);
            
            if (i.right != null)
                queue.add(i.right);
        }
    }
    
    public void leftView(Node i, int level) {
        
        if (i == null) {
            return;
        }
        
        if (level > max) {
            System.out.print(i.value + " ");
            max = level;
        }
        
        leftView(i.left, level+1);
        leftView(i.right, level+1);
        
    }
    
    public void treeLeftView() {
        BinaryTree.max = 0;
        leftView(root, 1);
    }
    
    
    public void rightView(Node i, int level) {
        
        if (i == null) {
            return;
        }
        
        if (level > max) {
            System.out.print(i.value + " ");
            max = level;
        }
        
        rightView(i.right, level+1);
        leftView(i.left, level+1);
        
        
    }
    
    public void treeRightView() {
        BinaryTree.max = 0;
        rightView(root, 1);
    }
    
    public void add(int key) {
        Node node = new Node(key);
        Node i = root;
        
        while(true) {
            if (i.value > key && i.left != null) {
                i = i.left;
            } else if (i.value <= key && i.right != null ) {
                i = i.right;
            }
            else
                break;
        }
        
        if (i.value > key) {
            i.left = node;
        } else {
            i.right = node;
        }
        
    }
    
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree(5);
        tree.add(4);
        tree.add(8);
        tree.add(7);
        tree.add(6);
        tree.add(9);
        
        System.out.println("In-order traversal:");
        tree.traverse(tree.root);
        
        System.out.println("\nLevel order traversal:");
        //5 4 8 7 9 6
        tree.levelOrder();
        
        System.out.println("\nLeft view:");
        //5 4 7 6
        tree.treeLeftView();

        System.out.println("\nRight view:");
        //5 8 9 6
        tree.treeRightView();
    }

}
