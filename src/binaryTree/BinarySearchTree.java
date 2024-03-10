package binaryTree;

public class BinarySearchTree {
    Node root;

    class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    public boolean insert(int value){
        Node newNode = new Node(value);

        if(root == null){
            root = newNode;
            return true;
        }

        Node curr = root;
        Node prev = null;

        while (true){
            if(curr == null){
                curr = newNode;
                break;
            }

            if(curr.value == newNode.value){
                return false;
            }

            if(value < curr.value){
                prev = curr;
                curr = curr.left;
            } else {
                prev = curr;
                curr = curr.right;
            }
        }

        if(value < prev.value){
            prev.left = curr;
        } else {
            prev.right = curr;
        }

        return true;
    }

    public boolean contains(int value){
        Node curr = root;

        while (curr != null){
            if(curr.value == value){
                return true;
            }

            if(value < curr.value){
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return false;
    }
}
