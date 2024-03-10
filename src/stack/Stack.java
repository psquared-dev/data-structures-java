package stack;

public class Stack {
    Node top;
    private int height;

    class Node{
        int value;
        Node next;

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

    public Stack(int value) {
        Node newNode = new Node(value);
        this.top = newNode;
        height = 1;
    }

    public int getHeight() {
        return height;
    }

    public void push(int value){
        Node newNode = new Node(value);

        if(height == 0){
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop(){
        if(height == 0){
            return null;
        }

        Node temp = top;
        top = top.next;
        temp.next = null;

        height--;
        return temp;
    }

    public void printStack(){
        Node temp = top;

        while (temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }

        System.out.println();
    }
}
