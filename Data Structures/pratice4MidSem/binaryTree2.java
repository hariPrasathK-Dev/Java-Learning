import java.util.LinkedList;
import java.util.Queue;

class Node {
    String value;
    Node left;
    Node right;
    Node parent;

    // Constructor for Node class
    public Node(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

class binaryTree2 {
    Node root;

    // Constructor for BinaryTree class
    public binaryTree2() {
        this.root = null;
    }

    // Method to insert a new node
    public void insert(String value) {
        Node newNode = new Node(value);
        if (this.root == null) {
            this.root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            Node parent = queue.poll();

            if (parent.left != null) {
                queue.add(parent.left);
            } else {
                parent.left = newNode;
                newNode.parent = parent;
                return;
            }

            if (parent.right != null) {
                queue.add(parent.right);
            } else {
                parent.right = newNode;
                newNode.parent = parent;
                return;
            }
        }
    }

    // Method to print all traversal orders
    public void order() {
        System.out.println("PREORDER");
        preorder(this.root);
        System.out.println("INORDER");
        inorder(this.root);
        System.out.println("POSTORDER");
        postorder(this.root);
    }

    // Preorder traversal
    private void preorder(Node parent) {
        if (parent != null) {
            System.out.println(parent.value);
            preorder(parent.left);
            preorder(parent.right);
        }
    }

    // Inorder traversal
    private void inorder(Node parent) {
        if (parent != null) {
            inorder(parent.left);
            System.out.println(parent.value);
            inorder(parent.right);
        }
    }

    // Postorder traversal
    private void postorder(Node parent) {
        if (parent != null) {
            postorder(parent.left);
            postorder(parent.right);
            System.out.println(parent.value);
        }
    }

    // Method to find the parent of a node with a given value
    public String findParent(String nodeValue) {
        Node parent = findParentHelper(this.root, nodeValue);
        return parent != null ? parent.value : null;
    }

    // Helper method to recursively find the parent of a node
    private Node findParentHelper(Node current, String targetValue) {
        if (current == null) {
            return null;
        }

        if ((current.left != null && current.left.value.equals(targetValue)) ||
            (current.right != null && current.right.value.equals(targetValue))) {
            return current;
        }

        Node leftResult = findParentHelper(current.left, targetValue);
        if (leftResult != null) {
            return leftResult;
        }

        return findParentHelper(current.right, targetValue);
    }

    // Main method for testing
    public static void main(String[] args) {
        binaryTree2 tree = new binaryTree2()
        tree.insert("A");
        tree.insert("B");
        tree.insert("C");
        tree.insert("D");
        tree.insert("E");
        tree.insert("F");
        tree.insert("G");
        tree.insert("H");
        tree.insert("I");

        System.out.println("Parent of E: " + tree.findParent("E")); // Should print the parent of node 'E'
        System.out.println("Parent of F: " + tree.findParent("F")); // Should print the parent of node 'F'
        
        // Traversals
        tree.order();
    }
}
