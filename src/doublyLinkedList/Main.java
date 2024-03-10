package doublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(10);

        dll.append(20);
//        dll.append(40);
//        dll.append(60);
//        dll.append(80);
//
//        dll.prepend(9);
//        dll.prepend(8);

        dll.printList();

        System.out.println(dll.insert(0, 5));
        System.out.println(dll.length);
        System.out.println(dll.insert(1, 12));
//        System.out.println(dll.insert(2, 100));

        dll.printList();

        System.out.println(dll.remove(0));
        System.out.println(dll.remove(1));

//        System.out.println(dll.set(0, 11));
//        System.out.println(dll.set(41, 1111));

//        System.out.println(dll.get(0));
//        System.out.println(dll.get(1));
//        System.out.println(dll.get(2));
//        System.out.println(dll.get(3));
//        System.out.println(dll.get(4));
//        System.out.println(dll.get(5));

//        System.out.println(dll.removeFirst());
//        System.out.println(dll.removeFirst());
//        System.out.println(dll.removeFirst());
//
//        System.out.println(dll.removeLast());
//        System.out.println(dll.removeLast());
//        System.out.println(dll.removeLast());

        dll.printList();
    }
}
