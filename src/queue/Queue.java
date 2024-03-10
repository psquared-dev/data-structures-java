package queue;

public class Queue {
    Node first;
    Node last;
    int length;

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

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        this.length = 1;
    }

    public int getLength() {
        return length;
    }

    public void enqueue(int value){
        Node newNode = new Node(value);

        if(length == 0){
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue(){
        if(length == 0){
            return null;
        }

        Node temp = first;

        if(length == 1){
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }

        length--;
        return temp;
    }

    public void printQueue(){
         Node temp = first;

         while(temp != null){
             System.out.print(temp.value + " ");
             temp = temp.next;
         }
         System.out.println();
    }
}
