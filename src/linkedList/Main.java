package linkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(11);
//        ll.append(222);
//        ll.append(10);
//        ll.append(100);

//        System.out.println(ll.remove(0));
//        System.out.println(ll.remove(2));

        ll.printList();

        ll.reverse();

        ll.printList();
    }
}
