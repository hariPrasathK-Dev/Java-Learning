public class linkedBinaryTree<T> {

    private static class Node<T> implements position<T> {
        T data;
        Node<T> parent;
        Node<T> leftChild;
        Node<T> rightChild;

        public Node(T data, Node<T> parent, Node<T> left, Node<T> right) {
            this.data = data;
            this.parent = parent;
            this.leftChild = left;
            this.rightChild = right;
        }

        public T getElement() {
            return data;
        }

        public Node<T> getParent() {
            return parent;
        }

        public Node<T> getLeft() {
            return leftChild;
        }

        public Node<T> getRight() {
            return rightChild;
        }

        public void setElement(T data) {
            this.data = data;
        }

        public void setParent(Node<T> p) {
            parent = p;
        }

        public void setLeft(Node<T> l) {
            leftChild = l;
        }

        public void setRight(Node<T> r) {
            rightChild = r;
        }
    }

    public Node<T> createNode(T data, Node<T> parent, Node<T> left, Node<T> right) {
        return new Node<T>(data, parent, left, right);
    }

    Node<T> root = null;
    int size = 0;

    public linkedBinaryTree() { }

    public Node<T> validate(position<T> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Not valid position type.");
        }

        Node<T> node = (Node<T>) p;
        if (node.getParent() == node) {
            throw new IllegalArgumentException("p is no longer in the tree.");
        }
        return node;
    }

    public int size() {
        return size;
    }

    public position<T> root() {
        return root;
    }

    public position<T> parent(position<T> p) {
        Node<T> node = validate(p);
        return node.getParent();
    }

    public position<T> left(position<T> l) {
        Node<T> node = validate(l);
        return node.getLeft();
    }

    public position<T> right(position<T> r) {
        Node<T> node = validate(r);
        return node.getRight();
    }

    public position<T> addRoot(T r) throws IllegalStateException {
        if (!isEmpty()) throw new IllegalStateException("Tree not empty!");

        root = createNode(r, null, null, null);
        size = 1;
        return root;
    }

    public position<T> addLeft(position<T> p, T d) throws IllegalArgumentException {
        Node<T> parent = validate(p);
        if (parent.getLeft() != null) throw new IllegalArgumentException("p already has a left child!");

        Node<T> child = createNode(d, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    public position<T> addRight(position<T> p, T d) throws IllegalArgumentException {
        Node<T> parent = validate(p);
        if (parent.getRight() != null) throw new IllegalArgumentException("p already has a right child!");

        Node<T> child = createNode(d, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    public T set(position<T> p, T d) {
        Node<T> node = validate(p);
        T temp = node.getElement();
        node.setElement(d);
        return temp;
    }

    public void attach(position<T> p, linkedBinaryTree<T> t1, linkedBinaryTree<T> t2) throws IllegalArgumentException {
        Node<T> node = validate(p);
        if (isInternal(p)) throw new IllegalArgumentException("p must be a leaf");
        size += t1.size() + t2.size();

        if (!t1.isEmpty()) {
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if (!t2.isEmpty()) {
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }

    public T remove(position<T> p) throws IllegalArgumentException {
        Node<T> node = validate(p);
        if (numChildren(p) == 2) {
            throw new IllegalArgumentException("p has two children");
        }
        Node<T> child = (node.getLeft() != null) ? node.getLeft() : node.getRight();
        if (child != null) {
            child.setParent(node.getParent());
        }
        if (node == root) {
            root = child;
        } else {
            Node<T> parent = node.getParent();
            if (node == parent.getLeft()) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }

        size--;
        T temp = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);
        return temp;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isInternal(position<T> p) {
        return numChildren(p) > 0;
    }

    public boolean isExternal(position<T> p) {
        return numChildren(p) == 0;
    }

    public boolean isRoot(position<T> p) {
        return p == root();
    }

    // Helper method to count children
    public int numChildren(position<T> p) {
        Node<T> node = validate(p);
        int count = 0;
        if (node.getLeft() != null) count++;
        if (node.getRight() != null) count++;
        return count;
    }

    public Node findLCA(Node curNode,int data1,int data2)
    {
        if(curNode == null)
        {
            return curNode ;
        }
        else if(curNode.data == data1 || curNode.data == data2)
        {}

    }
        public static void main(String[] args) {
            linkedBinaryTree<Integer> tree = new linkedBinaryTree<>();
            
            // Add root
            position<Integer> root = tree.addRoot(10);
            System.out.println("Root: " + root.getElement());
            
            // Add left and right children
            position<Integer> leftChild = tree.addLeft(root, 5);
            position<Integer> rightChild = tree.addRight(root, 15);
            
            System.out.println("Left Child of Root: " + tree.left(root).getElement());
            System.out.println("Right Child of Root: " + tree.right(root).getElement());
            
            // Update left child
            tree.set(leftChild, 20);
            System.out.println("Updated Left Child of Root: " + tree.left(root).getElement());
            
            // Remove right child
            tree.remove(rightChild);
            System.out.println("Right Child of Root after removal: " + tree.right(root));
        }
    
}
