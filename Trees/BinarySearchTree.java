


class Node {
    int value;
    Node right;
    Node left;
    
    Node(int key) {
        value = key;
        right = left = null;
    }
}


class BinarySearchTree {
    Node root;
    
    BinarySearchTree() {
        this.root = null;
    }
    
    public void add(int key) {
        //iterative method
        Node node = new Node(key);
        
        if (root == null) {
            root = node;
            return;
        }
        
        Node cur = root;
        while (true) {
            if (cur.value < key && cur.right != null)
                cur = cur.right;
            else if(cur.value > key && cur.left != null)
                cur = cur.left;
            else
                break;
        }
        
        if (cur.value > key)
            cur.left = node;
        else
            cur.right = node;
        
    }
     
    
    public void add(Node cur, int key) {
        if (cur == null) {
            cur = new Node(key);
            return;
        }
        
        if (cur.value > key) {
            if (cur.left == null)
                cur.left = new Node(key);
            else
                add(cur.left, key);
        } else {
            if (cur.right == null)
                cur.right = new Node(key);
            else
                add(cur.right, key);
        }
    }
    
    public void print(Node cur) {
        if (cur == null)
            return;
        if (cur.left != null)
            print(cur.left);
        
        System.out.println(cur.value);
        
        if (cur.right != null)
            print(cur.right);
        
    }
    
    public int height(Node cur) {
        if (cur == null)
            return 0;
        
        return 1 + (Math.max(height(cur.left), height(cur.right)));
    }
    
    public static void main(String srgs[]) {
        BinarySearchTree tree = new BinarySearchTree();
        
        tree.add(10);
        tree.add(tree.root, 9);
        tree.add(8);
        tree.add(7);
        tree.add(6);
        tree.add(5);
        tree.add(tree.root, 4);
        tree.add(3);
        tree.add(2);
        tree.add(11);
        
        
        tree.print(tree.root);
        
        System.out.println("Height of tree " + tree.height(tree.root));
        
    }
}
