package hashTable;

import java.util.ArrayList;
import java.util.List;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    class Node{
        String key;
        int value;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key='" + key + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    public HashTable() {
        this.dataMap = new Node[size];
    }

    private int hash(String key){
        int hash = 0;
        char[] keyChars = key.toCharArray();

        for (int i = 0; i < keyChars.length; i++) {
            int asciiKey = keyChars[i];
            hash = (hash + asciiKey * 23) % dataMap.length;
        }

        return hash;
    }

    public void set(String key, int value){
        int index = hash(key);

        Node newNode = new Node(key, value);

        if(dataMap[index] == null){
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];

            while (temp.next != null){
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    public int get(String key){
        int index = hash(key);
        Node temp = dataMap[index];

        while(temp != null){
            if(temp.key.equals(key)){
                return temp.value;
            }
            temp = temp.next;
        }

        return 0;
    }

    public List<String> keys(){
        ArrayList<String> keysList = new ArrayList<>();

        for (int i = 0; i < dataMap.length; i++) {
            if(dataMap[i]  != null){
                Node temp = dataMap[i];

                while (temp != null){
                    keysList.add(temp.key);
                    temp = temp.next;
                }
            }
        }

        return keysList;
    }

    public void printTable(){
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            System.out.println(i + ":");
            while (temp != null){
                System.out.print(temp + " ");
                temp = temp.next;
            }

            System.out.println();
        }

    }
}
