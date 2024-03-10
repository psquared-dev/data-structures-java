package hashTable;

public class Main {
    public static void main(String[] args) {
        HashTable ht1 = new HashTable();
        ht1.set("nails", 100);
        ht1.set("tile", 50);
        ht1.set("lumber", 80);

        ht1.set("bolts", 200);
        ht1.set("screws", 140);

        System.out.println(ht1.get("nails"));

        System.out.println(ht1.keys());

        ht1.printTable();
    }
}
