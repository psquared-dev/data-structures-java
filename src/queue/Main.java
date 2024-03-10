package queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(6);

        queue.enqueue(10);
        queue.enqueue(101);

        queue.printQueue();

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.printQueue();
    }
}
