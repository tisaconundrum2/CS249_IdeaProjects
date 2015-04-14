package com.project.project3;

import java.util.Scanner;

/**
 * Created by Zac on 10/27/2014.
 */
public class MNode {

    long iData;
    long dData;
    MNode onLeft;
    MNode onTop;

    //MNode Start;



    public MNode(long id, long dd){ iData = id; dData = dd;}

    public void displayMNode() {     // display yourself

        System.out.print(iData +""+ dData + " ");
    }

}


class MatrixList {

    public MNode Start;
    public MNode current;
    public MNode rowptr;
    int rowlength = 0;
    int columnlength = 0;

    public MatrixList() {

        Start = null;
        //count = 0;                         // no nodes in the list yet
        rowptr = null;
        current = null;


    }

    public void insertRight(long id,long dd) {
        MNode cNode = new MNode(id,dd);

        if (Start == null) {
            cNode.onLeft = current;
            current = cNode;
            Start = current;
        }
        else {

            while(current.onLeft != null){
                current = current.onLeft;
            }
            current.onLeft = cNode;
            current = current.onLeft;
            //cNode.onLeft = current;
            //current = cNode;
        }


    }

    public void insertDown(long id, long dd) {
        MNode cNode = new MNode(id, dd);
        MNode temp = null;
        if (Start.onTop == null) {
            Start.onTop = cNode;
            current = Start.onTop;
            //Start = current;
            columnlength++;
        }

        else {
            current = Start.onTop;
            while (current != null) {
                current = current.onTop;
            }
            current = cNode;

            //rowptr = cNode;
            columnlength++;
        }
    }
    public void display() {

        rowptr = Start;

        while(rowptr != null){
            rowptr.displayMNode();
            rowptr = rowptr.onLeft;
        }
        //System.out.println("rowlength: " + rowlength);
        //rowptr = Start;

        for(int l = 1; l<=columnlength; l++) {
            while(rowptr != rowptr){
                rowptr = rowptr.onLeft;
            }
            rowptr = Start.onTop;
                System.out.println(" ");
            while(rowptr != null){
                rowptr.displayMNode();
                rowptr = rowptr.onLeft;
            }
        }


        //rowptr = Start;
    }
}



class MatrixListApp{
    public static void main(String[] args) {
        //PNode i;
        MatrixList arr3;
        arr3 = new MatrixList();

        Scanner input = new Scanner(System.in);
        //boolean exit = true;



        System.out.println("Please enter the number of columns");  //I screwed up my naming here so, rows and columns are reversed.
        int rows = input.nextInt();
        System.out.println("Please enter the number of rows");     //See above
        int columns = input.nextInt();
        System.out.println("");
        //for(int j = 0; j<= columns-1; j++){
            //for(int i = 1; i<= rows; i++){
                //arr3.insertRight(0,i-1);
           // }
        arr3.insertRight(0,0);
        arr3.insertRight(0,1);
        arr3.insertRight(0,2);
        //arr3.insertRight(0,3);




            arr3.insertDown(1, 0);
            arr3.insertRight(1,1);
            arr3.insertRight(1,2);
            //arr3.insertDown(2, 0);

            //arr3.insertDown(columns - 1, 1);
            //for(int i = 1; i<= rows-1; i++){
                //arr3.insertRight(columns - 1,1);
            //}
        //}
        System.out.println("current: ");
        arr3.current.displayMNode();
        //System.out.println("rowptr: ");
        //arr3.rowptr.displayMNode();
        System.out.println("");
        System.out.println("Matrix");
        arr3.display();

    }
}



