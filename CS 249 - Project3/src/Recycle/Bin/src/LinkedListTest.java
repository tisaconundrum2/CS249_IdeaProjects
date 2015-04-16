package src;

/**
 * Created by SeanB on 10/30/2014.
 */
class Node{
    public int iData; // data item
    public double dData; // data item
    public Node isRight; // next link in list
    public Node isBelow; // next link in list
// ------------------------------------------------------------

    public Node(int id, double dd) // constructor
    {
        iData = id; // initialize data
        dData = dd; // ('next' is automatically
    } // set to null)
// ------------------------------------------------------------x

    public void displayLink() // display ourself
    {
        System.out.print("{" + iData + ", " + dData + "} ");}
}
// end class Link

class matrixList {
    private Node parent, goRight, goDown; // setting up all the things.

    public matrixList(int id, double dd){//Constructor
        parent =  goRight = goDown = null;
        Node newNode = new Node(id, dd);
        parent = goDown = goRight = newNode;
    }

    public boolean isEmpty() // true if list is empty
    {
        return (goDown == null || goRight == null);
    }

    public void insertRight(int id, double dd){
        Node newNode = new Node(id, dd);
        goDown = goRight;
        while (goRight != null){//traverse the list until a null node is found
            goRight = goRight.isRight;//set your goright to be that node
        }
        goRight = newNode;//add the newNode to that null node
        goDown.isRight = goRight;//add your newNode to the rest of the list.
        goRight = goDown;//finally make goRight contain the list.
    }

    public void insertBelow(int id, double dd){
        Node newNode = new Node(id, dd);
        newNode.isRight = goDown;
        goDown = newNode;
    }

    public void fill(int id, double dd, int xCount,int yCount){
        int tempX = 0;
        int tempY = 0;
        while (tempX != xCount){
            Node newNode = new Node(id, dd);
            goRight.isRight = goRight;
            goRight = newNode;
            tempX++;
        }

        while (tempY != yCount){
            Node newNode = new Node(id, dd);
            newNode.isRight = goDown;
            goDown = newNode;
        }
    }
}


/*

public void insertBelow(id,dd){
	if (header== null)//this does a check to see if the header Node even exists.
		//TODO: add a node
		Node header = new Node(id,dd)

	else
		//TODO: insert a Node below
		newNode.isBelow = current //cuurent moves right as well as down.
		newNode.isBelow = footer // footer only goes down.

}

public void insertRight(id,dd){
	if (header == null )//this does a check to see if the header Node even exists.
		//TODO: add new node
		Node header = new Node(id,dd)
	else
		//TODO: insert a node to the right
	newNode.isRight = current
}


h
[x]
 f  c
[x][x]





12  c
[1][2]
[3]

[4][3][2][1]->null

first
[0][0][0][0]->
[0][0][0][0]->
[0][0][0][0]->
[0][0][0][0]->
[0][0][0][0]->

c.below.right = c.right.below

current.right.down = newNode
current.down.right = newNode




first = temp.isright
first.isright = new




 */