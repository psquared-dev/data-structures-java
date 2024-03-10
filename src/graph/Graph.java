package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {

    enum GraphType{
        DIRECTED,
        UNDIRECTED
    }

    Map<String, Node> nodes;
    GraphType type;

    public Graph() {
        this.nodes = new HashMap<>();
        this.type = GraphType.UNDIRECTED;
    }

    public Graph(String type) {
        this.nodes = new HashMap<>();
        this.type = GraphType.valueOf(type);
    }

    class Node{
        String value;
        Set<Node> adjacents = new HashSet<>();

        public Node(String value) {
            this.value = value;
        }

        boolean removeAdjacent(Node node){
            return this.adjacents.remove(node);
        }

        boolean addAdjacent(Node node){
            return this.adjacents.add(node);
        }

        boolean isAdjacent(Node node){
            return this.adjacents.contains(node);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + "}";
        }
    }

    public boolean addVertex(String name){
        if(nodes.containsKey(name)){
            return false;
        }

        Node newNode = new Node(name);
        nodes.put(name, newNode);
        return true;
    }

    public boolean addEdge(String source, String dest){
        addVertex(source);
        addVertex(dest);

        Node sourceNode = nodes.get(source);
        Node destNode = nodes.get(dest);

        sourceNode.addAdjacent(destNode);

        if(type == GraphType.UNDIRECTED){
            destNode.addAdjacent(sourceNode);
        }

        return true;
    }

    public boolean removeVertex(String name){
        if(!nodes.containsKey(name)){
            return false;
        }

        Node target = nodes.get(name);

        for (Map.Entry<String, Node> entry : nodes.entrySet()) {
            entry.getValue().removeAdjacent(target);
        }

        nodes.remove(name);

        return true;
    }

    public boolean removeEdge(String source, String dest){
        if(!nodes.containsKey(source)){
            return false;
        }

        if(!nodes.containsKey(dest)){
            return false;
        }

        Node sourceNode = nodes.get(source);
        Node destNode = nodes.get(dest);

        sourceNode.removeAdjacent(destNode);

        if(type == GraphType.UNDIRECTED){
            destNode.removeAdjacent(sourceNode);
        }

        return true;
    }

    public void printGraph() {
        for (Map.Entry<String, Node> entry : nodes.entrySet()) {
            System.out.println(entry.getKey() + ":");

            for (Node node : entry.getValue().adjacents) {
                System.out.println(node);
            }
            System.out.println("");
        }
    }
}
