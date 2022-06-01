package ADS_week8;

import java.util.Stack;

public class Graph {
    private int[][]mas;
    Node[] vertexList;
    private int curN;
    public Graph(int maxN){
        vertexList=new Node[maxN];
        mas=new int[maxN][maxN];
        curN=0;
    }
    public void addVertex(char name)
    {
        vertexList[curN++]=new Node(name);
    }
    public void addEdge(int start, int end)
    {
        mas[start][end]=1;
        mas[end][start]=1;
    }
    public int check(int v)
    {
        for (int i = 0; i < curN; i++) {
            if (mas[v][i]==1&&vertexList[i].isVisited==false)
            {
                return i;
            }
        }
        return -1;
    }

    public void DeepFirstSearch(int index)
    {
        Stack<Integer> stack = new Stack<>();
        System.out.println(vertexList[index].name);
        vertexList[index].isVisited=false;
        stack.push(index);
        while (!stack.empty())
        {
            int neighbor = check(stack.peek());
            if (neighbor==-1)
            {
                neighbor=stack.pop();
            }
            else {
                System.out.println(vertexList[neighbor].name);
                  vertexList[neighbor].isVisited = true;
                stack.push(neighbor);
            }
        }
        for (int i = 0; i < curN; i++) {
            vertexList[i].isVisited=false;
        }
    }
}
