package com.company.Graphs;

import com.company.Graphs.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



////////////////////////////////////////////////////////////////
class WarshallApp{
    public static void main(String[] args) throws IOException{
        Graph theGraph = new Graph();
        theGraph.addVertex("A");    // 0
        theGraph.addVertex("B");    // 1
        theGraph.addVertex("C");    // 2
        theGraph.addVertex("D");    // 3
        theGraph.addVertex("E");    // 4

        theGraph.addEdge(0, 2);     // AC
        theGraph.addEdge(1, 0);     // BA
        theGraph.addEdge(1, 4);     // BE
        theGraph.addEdge(3, 4);     // DE
        theGraph.addEdge(4, 2);     // EC

        System.out.println("Original adjacency matrix");
        theGraph.adjMatDisplay();   // display adj matrix
        theGraph.warshall();        // do the algorithm
        System.out.println();
    }  // end main()
// -------------------------------------------------------------
}  // end class WarshallApp
