/*
*
*
* Name: Kadessov Bek
*
* Subject: Algorithms and Data structures
*
* Task: implementing Bellman–Ford Algorithm (BFA)
*
*
* */

package ADS.tasks;
import java.lang.*;
public class week9_graphs_main {
    public static void main(String[] args)
    {
        int V = 5; // the number of vertexes
        int E = 8; // the number of edges
        Node node = new Node(V, E); // creating graph object
        graphAlgorithms algo = new graphAlgorithms(); // collection of graph algorithms

        // connecting vertex A with B, where weight is -1
        node.edge[0].from = 'A';
        node.edge[0].toNode = 'B';
        node.edge[0].weight = -1;

        // connecting vertex A with C, where weight is 4
        node.edge[1].from = 'A';
        node.edge[1].toNode = 'C';
        node.edge[1].weight = 4;

        // connecting vertex B with C, where weight is 3
        node.edge[2].from = 'B';
        node.edge[2].toNode = 'C';
        node.edge[2].weight = 3;

        // connecting vertex B with D, where weight is 2
        node.edge[3].from = 'B';
        node.edge[3].toNode = 'D';
        node.edge[3].weight = 2;

        // connecting vertex B with E, where weight is 2
        node.edge[4].from = 'B';
        node.edge[4].toNode = 'E';
        node.edge[4].weight = 2;

        // connecting vertex D with C, where weight is 5
        node.edge[5].from = 'D';
        node.edge[5].toNode = 'C';
        node.edge[5].weight = 5;

        // connecting vertex D with B, where weight is 1
        node.edge[6].from = 'D';
        node.edge[6].toNode = 'B';
        node.edge[6].weight = 1;

        // connecting vertex E with D, where weight is -3
        node.edge[7].from = 'E';
        node.edge[7].toNode = 'D';
        node.edge[7].weight = -3;

        algo.BFA(node, 'A'); // BFA algorithm, starting point is A node
    }
}
class Node {
    int V, E;
    Edge edge[];
    Node(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }
}
class graphAlgorithms{
    private int from;
    int infinity = Integer.MAX_VALUE;
    public void BFA(Node graph, char from)
    {
        this.from = from-'A';
        int V = graph.V, E = graph.E;
        int toNode[] = new int[V];

        for (int i = 0; i < V; i++) {
            toNode[i] = infinity; // Max value of integer instead infinity
        }
        toNode[this.from] = 0;

        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {
                char temp1,temp2;
                temp1 = graph.edge[j].from;
                temp2 = graph.edge[j].toNode;
                int weight = graph.edge[j].weight;
                if (toNode[temp1-'A'] != infinity && toNode[temp1-'A'] + weight < toNode[temp2-'A'])
                    toNode[temp2-'A'] = toNode[temp1-'A'] + weight;
            }
        }


        for (int i = 0; i < E; i++) {
            char temp1,temp2;
            temp1 = graph.edge[i].from;
            temp2 = graph.edge[i].toNode;
            int weight = graph.edge[i].weight;
            if (toNode[temp1-'A'] != infinity && toNode[temp1-'A'] + weight < toNode[temp2-'A']) {
                System.out.print("Impossible to find!\n An infinite loop is detected due to a negative number\n");
                break;
            }
            // only in BFA algorithm, if there would be loop with negative value of weight, algorithm will not scan infinitely
        }
// checks every edge instead like DFS algorithm than finding every vertex ‘s short path step by step.


        // Display results: cost of each vertex in graph according to starting point
        System.out.print("Vertex: | Distance from Source:\n");
        for (int i = 0; i < V; ++i){
            String space = "";
            if (toNode[i]>=0) space = " ";
                System.out.println((char)('A'+i) + "\t    |" + space + toNode[i]);
            }
    }
    // Dynamic programming approach
    // Time complexity is more than Dijkstra algorithm
}
class Edge {
    public char from, toNode;
    public int weight;
    Edge()
    {
        from = toNode = 'A';
        weight = 0;
    }
};
