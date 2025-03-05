import java.util.ArrayList;

public class binaryTree {

    private class Node {
        int data;
        Node parent;
        Node leftChild;
        Node rightChild;

        public Node(int data) {
            this.data = data;
            leftChild = rightChild = null;
        }
    }

    Node root;
    int size;

    public binaryTree() {
        root = null;
    }

    public void createTree(int[] arr) {
        if (arr.length == 0) return;

        ArrayList<Node> node = new ArrayList<>();
        node.add(null);  // Adding a null node to start indexing from 1
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                Node tempNode = new Node(arr[i]);
                node.add(tempNode);

                if (i != 0) {
                    int parentIndex = ((i - 1) / 2) + 1;
                    Node parentNode = node.get(parentIndex);

                    if (parentNode != null) {
                        tempNode.parent = parentNode;
                        if (i % 2 == 1) {
                            parentNode.leftChild = tempNode;
                        } else {
                            parentNode.rightChild = tempNode;
                        }
                    }
                }
            } else {
                node.add(null);
            }
        }

        this.root = node.get(1);
        size = node.size() -1;
    }

    public void preorderTraversal(Node curNode) {
        if (curNode == null) return;

        System.out.print(curNode.data + " ");
        preorderTraversal(curNode.leftChild);
        preorderTraversal(curNode.rightChild);
    }

    public static void main(String[] args) {
        binaryTree b1 = new binaryTree();

        int[] a = {6, 5, 3, 4, 2, 1};

        b1.createTree(a);

        b1.preorderTraversal(b1.root);
        System.out.println();
        System.out.println(b1.size);
    }
}
