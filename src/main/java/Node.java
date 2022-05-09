public class Node {
    int data;
    Node left;
    Node right;
    Node parent; // used in SimpleBinaryTree + red-black tree
    boolean color; // used in red-black tree

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
}

