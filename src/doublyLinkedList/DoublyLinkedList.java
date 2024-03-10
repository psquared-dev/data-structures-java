package doublyLinkedList;

public class DoublyLinkedList {
    Node head;
    Node tail;
    int length;

    class Node{
        int value;
        Node next;
        Node prev;

        Node(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length++;
    }

    public void append(int value){
        Node newNode = new Node(value);

        if(length == 0){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        length++;
    }

    public Node removeLast(){
        if(length == 0){
            return null;
        }

        Node temp = tail;

        if(length == 1){
            head = null;
            tail = null;
            length--;
            return temp;
        }

        // last node
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        length--;
        return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value);

        if(length == 0){
            head = newNode;
            tail = newNode;
            length++;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        length++;
    }

    public Node removeFirst(){
        if(length == 0){
            return null;
        }

        Node temp = head;

        if(length == 1){
            head = null;
            tail = null;
            length--;
            return temp;
        }


        head = head.next;
        head.prev = null;
        temp.next = null;
        length--;
        return temp;
    }

    public Node get(int index){
        if(index < 0 || index >= length){
            return null;
        }

        Node temp;

        if(index < length / 2){
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }

        return temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index);

        if(temp != null){
            temp.value = value;
            return true;
        }

        return  false;
    }

    public boolean insert(int index, int value){

        if(index < 0 || index > length){
            return false;
        }

        if(index == 0){
            prepend(value);
            return true;
        }

        if(index == length){
            append(value);
            return true;
        }

        Node temp = get(index);
        Node newNode = new Node(value);

        newNode.next = temp.next;
        temp.next.prev = newNode;
        newNode.prev = temp;
        temp.next = newNode;
        length++;
        return true;
    }
    public Node remove(int index){
        if(index < 0 || index >= length ){
            return  null;
        }

        if(index == 0){
            return removeFirst();
        }

        if(index == length - 1){
            return removeLast();
        }

        Node temp = get(index);
        Node prev = temp.prev;
        Node next = temp.next;

        prev.next = temp.next;
        next.prev = prev;

        temp.prev = null;
        temp.next = null;

        length--;

        return temp;
    }

    public void printList(){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }

        System.out.println();
    }


}
