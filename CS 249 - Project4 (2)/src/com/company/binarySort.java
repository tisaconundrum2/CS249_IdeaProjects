package com.company;

/**
 * Created by Nicholas Finch on 11/16/2014.
 */
class studentGPAs{
    public double GPA;
    public String name;
    public studentGPAs isLeft, isRight;

    public String displayNode(){
        //TODO display data from Nodes.
        return "Student: "+name+"\n GPA: "+GPA;
    }
}

class Tree{
    private studentGPAs root; // the only data field in Tree

    public studentGPAs find(int key)
    {
        studentGPAs current = root;
        while (current.GPA != key){
            if (key < current.GPA)
                current = current.isLeft;
            else
                current = current.isRight;
            if (current == null)
                return null;
        }
        return current;
    }

    public void insert(double gpa, String name)
    {
        studentGPAs newGPA = new studentGPAs();
        newGPA.GPA = gpa;
        newGPA.name = name;
        if (root == null)
            root = newGPA;
        else{
            studentGPAs current = root;
            studentGPAs parent;
            while (true){
                parent = current;
                if (gpa < current.GPA) { //go left?
                    current = current.isLeft;
                    if (current == null) {
                        parent.isLeft = newGPA;
                        return;
                    }
                }
                else {
                    current = current.isRight;
                    if (current == null){
                        parent.isRight = newGPA;
                        return;
                    }
                }//end else
            }//end while
        }//end else not root
    } //end insert

    public boolean delete(double key)
    {
        studentGPAs current = root;
        studentGPAs parent = root;
        boolean isLeftChild = true;

        while (current.GPA != key)
        {
            parent = current;
            if (key < current.GPA)
            {
                isLeftChild = true;
                current = current.isLeft;
            }
            else
            {
                isLeftChild = false;
                current = current.isRight;
            }
            if (current == null)
                return false;
        }//end while

        if (current.isLeft == null && current.isRight == null)
        {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.isLeft = null;
            else
                parent.isRight = null;
        }
        else if (current.isRight == null) {
            if (current == root)
                root = current.isLeft;
            else if (isLeftChild)
                parent.isLeft = current.isLeft;
            else
                parent.isRight = current.isLeft;
        }
        else if (current.isLeft == null){
            if (current == root)
                root = current.isRight;
            else if (isLeftChild)
                parent.isLeft = current.isRight;
            else
                parent.isRight = current.isRight;
        }
        else {
            studentGPAs successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.isLeft = successor;
            else
                parent.isLeft = successor;
            successor.isLeft = current.isLeft;
        }
        return true;
    }

    private studentGPAs getSuccessor(studentGPAs delNode)
    {
        studentGPAs successorParent = delNode;
        studentGPAs successor = delNode;
        studentGPAs current = delNode.isRight; // go to right child
        while(current != null) // until no more
        { // left children,
            successorParent = successor;
            successor = current;
            current = current.isLeft; // go to left child
        }

        if(successor != delNode.isRight) // right child,
        { // make connections
            successorParent.isLeft = successor.isRight;
            successor.isRight = delNode.isRight;
        }
        return successor;
    }

    private void inOrder(studentGPAs localRoot)
    {
        if(localRoot != null)
        {
            inOrder(localRoot.isLeft);
            localRoot.displayNode();
            inOrder(localRoot.isRight);
        }
    }

    public studentGPAs minimum() // returns node with minimum key value
    {
        studentGPAs current, last = null;
        current = root; // start at root
        while(current != null) // until the bottom,
        {
            last = current; // remember node
            current = current.isLeft; // go to left child
        }
        return last;
    }

    public studentGPAs maximum() // returns node with minimum key value
    {
        studentGPAs current, last = null;
        current = root; // start at root
        while(current != null) // until the bottom,
        {
            last = current; // remember node
            current = current.isRight; // go to left child
        }
        return last;
    }

    public void inOrder() {

    }

// various other methods
} // end class Tree