package graph;

public class Main {
    public static void main(String[] args) {
        Graph g1 = new Graph();

        g1.addVertex("google");
        g1.addVertex("bing");
        g1.addVertex("duck");

        g1.addEdge("google", "bing");
        g1.addEdge("google", "duck");
        g1.addEdge("bing", "duck");

        g1.printGraph();

//        System.out.println(g1.removeVertex("google"));
        System.out.println("##############");

        g1.removeEdge("duck", "bing");

        g1.printGraph();
    }
}
