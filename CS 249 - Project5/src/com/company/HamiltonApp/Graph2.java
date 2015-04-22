package com.company.HamiltonApp;

import java.util.Arrays;

/**
 * Created by User on 4/22/2015.
 */
public class Graph2{

    private final int MAX_VERTS = 10;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private char sortedArray[];
    private int V, pathCount;
    private int[] path;
    private int[][] graph;


    public Graph2(){
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int j=0; j<MAX_VERTS; j++)
            for(int k=0; k<MAX_VERTS; k++)
                adjMat[j][k] = 0;
        sortedArray = new char[MAX_VERTS];
    }

    public void addVertex(char lab){
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end){

        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v){
        System.out.print(vertexList[v].label);
    }



    public char startV(int i) {

        if(i == 0)
            return 'A';

        else if(i == 1)
            return 'B';

        else if(i == 2)
            return 'C';

        else if(i == 3)
            return 'D';

        else
            return 'E';

    }


    public void findCycle(){

        int[][] g = adjMat;

        V = g.length;
        path = new int[V];

        Arrays.fill(path, -1);
        graph = g;
        try
        {
            path[0] = 0;
            pathCount = 1;
            solve(0);
            System.out.println("No solution");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            display();
        }
    }

    public void solve(int vertex) throws Exception
    {

        if (graph[vertex][0] == 1 && pathCount == V)
            throw new Exception("Solution found");

        if (pathCount == V)
            return;

        for (int v = 0; v < V; v++)
        {

            if (graph[vertex][v] == 1 )
            {
                /** add to path **/
                path[pathCount++] = v;
                /** remove connection **/
                graph[vertex][v] = 0;
                graph[v][vertex] = 0;


                if (!isPresent(v))
                    solve(v);


                graph[vertex][v] = 1;
                graph[v][vertex] = 1;

                path[--pathCount] = -1;
            }
        }
    }
    /** function to check if path is already selected **/
    public boolean isPresent(int v)
    {
        for (int i = 0; i < pathCount - 1; i++)
            if (path[i] == v)
                return true;
        return false;
    }
    /** display solution **/
    public void display()
    {
        System.out.print("\nPath : ");
        for (int i = 0; i <= V; i++)
            System.out.print(path[i % V] +" ");
        System.out.println();
    }




}//end graph
