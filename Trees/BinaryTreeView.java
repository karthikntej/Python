
class Node {
    int value;
    Node right;
    Node left;
    
    Node(int key) {
        value = key;
        right = left = null;
    }
}


class BinaryTreeView {
    Node root;
    public static int visitedLevel;
    
    BinaryTreeView() {
        this.root = null;
    }
    
    //iterative method
    public void add(int key) {
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
    
    //recursive method
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
    
    //Inorder traversal
    public void print(Node cur) {
        if (cur == null)
            return;
        if (cur.left != null)
            print(cur.left);
        
        System.out.println(cur.value);
        
        if (cur.right != null)
            print(cur.right);
        
    }
    
    //tree left view
    
    public void treeLeftView(Node node, int curLevel) {
        if (node == null)
            return;
        
        if (curLevel > visitedLevel) {
            System.out.println(node.value);
            visitedLevel = curLevel;
        }
        treeLeftView(node.left, curLevel+1);
        treeLeftView(node.right, curLevel+1);
    }
    
    //Tree right view
    public void treeRightView(Node node, int curLevel) {
        if (node == null)
            return;
        
        if (curLevel > visitedLevel) {
            System.out.println(node.value);
            visitedLevel = curLevel;
        }
        treeRightView(node.right, curLevel+1);
        treeRightView(node.left, curLevel+1);
        
    }
    
    //Get height of the tree
    public int height(Node cur) {
        if (cur == null)
            return 0;
        
        return 1 + (Math.max(height(cur.left), height(cur.right)));
    }
    
    public static void main(String srgs[]) {
        BinaryTreeView tree = new BinaryTreeView();
        
//                    5
//                  /   \
//                4      9
//               /      /
//             2       6
//            / \       \
//           1   3       8
        
        tree.add(5);
        tree.add(tree.root, 4);
        tree.add(2);
        tree.add(1);
        tree.add(3);
        tree.add(tree.root, 9);
        tree.add(6);
        tree.add(8);
        
        
        visitedLevel = 0;
        System.out.println("Left view of tree" );
        tree.treeLeftView(tree.root, 1);
        
        visitedLevel = 0;
        System.out.println("Rigth view of tree" );
        tree.treeRightView(tree.root, 1);
    }
}
