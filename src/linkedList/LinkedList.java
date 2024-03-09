package linkedList;

public class LinkedList {
    Node head;
    Node tail;
    int length;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value){
        Node newNode = new Node(value);

        if(length == 0){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {

        // there are no nodes, return
        if (length == 0) {
            return null;
        }

        // list has only 1 node
        if(length == 1){
            Node temp = head;
            head = tail = null;
            length--;
            return temp;
        }

        //   list has more than 1 node
        Node temp = head;
        Node pre = head;

        while(temp.next != null){
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;
        length--;
        return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value);

        if(length == 0){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if(length == 0){
            return null;
        }

        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        if(length == 0){
            tail = null;
        }

        return temp;
    }

    public Node get(int index){
        if(index < 0 || index >= length){
            return null;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        } else {
            return false;
        }
    }

    public boolean insert(int index, int value){
        if(index < 0 || index > length){
            return false;
        }

        if(index == 0){
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index - 1);

        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index){
        if(index < 0 || index >= length){
            return null;
        }

        if(index == 0){
            return removeFirst();
        }

        if(index == length - 1){
            return removeLast();
        }

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next = null;

        tail = head;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public void printList(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
