package binaryTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst1 = new BinarySearchTree();

        bst1.insert(47);
        bst1.insert(21);
//        bst1.insert(76);
//        bst1.insert(18);
//        bst1.insert(52);
//        bst1.insert(82);
//        bst1.insert(27);

        System.out.println(bst1.contains(12));
        System.out.println(bst1.contains(47));
        System.out.println(bst1.contains(27));

//        System.out.println(bst1.root.left.right.value);

    }
}
