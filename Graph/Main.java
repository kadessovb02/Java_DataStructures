package ADS_week8;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addEdge(0,1);

        graph.addVertex('D');
        graph.addEdge(1,2);

        graph.addVertex('E');
        graph.addEdge(2,3);

        graph.addVertex('F');
        graph.addEdge(0,4);
        graph.addEdge(4,5);

        graph.DeepFirstSearch(1);
    }
}
