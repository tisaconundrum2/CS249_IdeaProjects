import java.io.*;

/**
 * Created by Zac on 12/4/2014.
 */
public class Vertex {

    public char label;

    public Vertex(char lab){
        label = lab;
    }

}

class Graph{

    private final int MAX_VERTS = 10;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private char sortedArray[];


    public Graph(){
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

    public void adjMatDisplay(){
        for(int i=0; i<nVerts; i++){
            for(int j=0; j<nVerts; j++){
                System.out.printf("%5d ", adjMat[i][j]);
            }
            System.out.println();
        }
    }

    public void warshall() {

        System.out.println();
        int distanceMatrix[][] = new int[nVerts + 1][nVerts + 1];

        for(int source = 1; source <= nVerts; source++){
            for(int destination = 1; destination <nVerts; destination++){
                distanceMatrix[source][destination] = adjMat[source][destination];
            }
        }

        for (int intermediate = 1; intermediate <= nVerts; intermediate++){
            for (int source = 1; source <= nVerts; source++){
                for (int destination = 1; destination <= nVerts; destination++){
                    if (distanceMatrix[source][intermediate] + distanceMatrix[intermediate][destination] < distanceMatrix[source][destination])
                        distanceMatrix[source][destination] = distanceMatrix[source][intermediate] + distanceMatrix[intermediate][destination];
                }
            }
        }

        for (int source = 1; source <= nVerts; source++)
            System.out.print("\t" + source);

        System.out.println();
        for (int source = 1; source <= nVerts; source++)
        {
            System.out.print(source + "\t");
            for (int destination = 1; destination <= nVerts; destination++)
            {
                System.out.print(adjMat[source][destination] + "\t");
            }
            System.out.println();
        }
    }
}

class WarshallApp{
    public static void main(String[] args) throws IOException{
        Graph theGraph = new Graph();
        theGraph.addVertex('A');    // 0
        theGraph.addVertex('B');    // 1
        theGraph.addVertex('C');    // 2
        theGraph.addVertex('D');    // 3
        theGraph.addVertex('E');    // 4

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

