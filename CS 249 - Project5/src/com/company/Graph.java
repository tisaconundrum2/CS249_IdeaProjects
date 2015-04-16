package com.company;

/**
 * Created by User on 12/9/2014.
 */
import java.util.*;

public class Graph {
    int numVertices = 0; //the number of vertices
    int numEdges = 0; //the number of edges
    public byte[][] graphArray; //the initial graph
    public byte[][] transGraphArray; //the transitive closure graph
    ArrayList vertexList = new ArrayList(); //list of the names of the vertices
    ArrayList<Integer> edgeListX = new ArrayList(); //list of the x components of the edges
    ArrayList<Integer> edgeListY = new ArrayList(); //list of the y components of the edges
    boolean isSetUp = false; //has the graph been set up yet?

    public Graph()
    {
        //constructor 'cause it was grumpy.
    }
    public void addVertex(String label) //takes a new vertex
    {
        numVertices++;
        vertexList.add(label);
        isSetUp = false; //let the other methods know that the graph has changed
    }
    public void addEdge(int x, int y) //takes a new edge
    {
        numEdges++;
        edgeListX.add(x);
        edgeListY.add(y);
        isSetUp = false; //let the other methods know that the graph has changed
    }
    public void setUpGraph()
    {
        graphArray = new byte[numVertices][numVertices];
        for (int i=0;i<numEdges;i++)
        {
            if (edgeListX.get(i) < numVertices && edgeListY.get(i) < numVertices) //check if the given edge will fit in the array/is part of the graph
            {
                graphArray[edgeListX.get(i)][edgeListY.get(i)] = 1; //if it does, set the corresponding bit to one
            }
            else
            {
                System.out.println("That edge specification is not in the graph matrix.");
            }
        }
    }
    public void adjMatDisplay() //function to display the graph
    {
        if (isSetUp == false)//check if the graph is set up
        {
            setUpGraph();
            isSetUp = true;
        }
        System.out.print("    ");
        for (int i=0; i<numVertices; i++)
        {
            System.out.print(vertexList.get(i) + "   "); //print the labels across the top
        }
        System.out.print("\n  =====");
        for (int i=0; i<numVertices; i++)
        {
            System.out.print("===");
        }
        for (int i=0; i<numVertices; i++)
        {
            System.out.print("\n" + vertexList.get(i) + "   "); //print the labels across the side
            for (int j=0; j<numVertices; j++)
            {
                System.out.print(graphArray[i][j] + "   "); //print the graph data
            }
        }
        System.out.print("\n\n");
    }
    public void adjMatDisplay(byte[][] printGraphArray) //function to display the graph given an input
    {
        if (isSetUp == false) //check if the graph is set up
        {
            setUpGraph();
            isSetUp = true;
        }

        System.out.print("    ");
        for (int i=0; i<numVertices; i++)
        {
            System.out.print(vertexList.get(i) + "   "); //print the labels across the top
        }
        System.out.print("\n  =====");
        for (int i=0; i<numVertices; i++)
        {
            System.out.print("===");
        }
        for (int i=0; i<numVertices; i++)
        {
            System.out.print("\n" + vertexList.get(i) + "   "); //print the labels across the side
            for (int j=0; j<numVertices; j++)
            {
                System.out.print(printGraphArray[i][j] + "   "); //print the graph data
            }
        }
        System.out.print("\n\n");
    }
    public void warshall()
    {
        if (isSetUp == false) //check if the graph is set up
        {
            setUpGraph();
            isSetUp = true;
        }
        transGraphArray = graphArray; //make a different copy of the 2D array for the algorithm to play with
        for(int k=0;k<numVertices; k++) //cycle through each column
        {
            for(int i=0;i<numVertices; i++) //and through each row
            {
                if (transGraphArray[i][k]==0) //check if it points somewhere
                {
                    continue; //if it doesn't, don't do anything
                }
                for(int j=0;j<numVertices; j++) //but if it does, cycle through the k rows
                {
                    if(transGraphArray[i][k]==1 && transGraphArray[k][j]==1) //and set the ones that match
                    {
                        transGraphArray[i][j]=1; //to 1.
                    }
                }
            }
        }
        adjMatDisplay(transGraphArray); //display the transitive closure graph
    }
}