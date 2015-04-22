package com.company.BSTstudents;

/**
 * Comments for your BST Class
 *
 * @author
 * @version
 * @since
 */

/* 
Inheritance in Java: extends 

Java features single inheritance, which means that each class can only inherit from one other class.
When you inherit another Object by extending, your class gains all the methods and variables of that class.

Here, the Generic type "Value" is extending Comparable<Value>, which forces Value to always use the Comparable interface.
We do this because we want to ensure that any Object Type we store in our BST can be compared against similar 
Objects so that we know how to organize them.

Comparable adds the method "compareTo()" to the class that implements it, allowing us to compare objects inside 
boolean statements. For example, if the Generic object "Value" extends comparable, then I and the compiler
know that these statements will work in this Class and the Node private Class:

Value parent = root;
Value new_node = input_value;

if(new_node.compareTo(parent) <= 0) 
	System.out.println("The new node is smaller than or equal to our root value!");

If this concept is not clear, please research it online and consider visiting office hours.
You can delete this comment when you no longer need it.
*/

/**
 * The student now has a Name and GPA.
 * call student.getName() to access their name
 * call student.getGPA() to access their GPA
 */


public class BinarySearchTree <Value extends Comparable>{
    private Value root, current; //remember Value can be anything. in this case it will be holding a student
    private int n;

    public BinarySearchTree(Value parent){
        this.root = root;
        current = root;
    }

    public BinarySearchTree() {

    }


    /**
     *
     * TODO check to see the current Node is null.
     */
    public boolean isEmpty() {
        if (n <= 0)
            return true;
        return false;
    }

    /**
     * TODO get the size of what?
     */
    public int getSize() {
        return n;
    }


    /**
     * TODO Find a certain Node
     */
    public Value find(Value val) {
        Value key = val;

        return val;
    }


    /**
     * TODO insert a Node into the BST,
     * if it's empty simply add to the root
     * if it's not, do a check on it's value
     * place the element in the left or right
     */
    public void insert(Value val) {
        Node newNode = new Node(val);//this creates a newNode with the student inside it.



        if(root == null){
            root = val; //the root is now pointing to the student value
        }
        else{
            current = root;
            while(true){
                root = current;

                if(current.compareTo(newNode) < 0){
                    //System.out.println("True");
                    current = newNode.leftChild;
                    if(current == null) {
                        root.left = newNode;
                        return;
                    }
                }
                else{
                    //System.out.println("False");
                    current = current.right;
                    if(current == null) {
                        root.right = newNode;
                        return;
                    }
                }
            }
        }

        n++;
        return;
    }


    /**
     * TODO seach through the BST
     * find the student with the key value
     * delete that Node. Get a successor to
     * replace the deleted Parent
     */
    public void delete(Value val) {

    }


    /**
     * TODO Print the BST in Level Order.
     * Utilize your BST methods from your previous
     * assignment
     */
    public void printLevelOrder(){
    }


    /**
     * TODO BST Node
     * It should have these
     *
     * [Node    ]
     * [val     ]
     * [Left Ch ]
     * [Right Ch]
     * [student ]
     *
     * [student ]
     * [name    ]
     * [gpa     ]
     */

    private class Node {
        /**
         * remember the value can be anything
         * Node
         * [Value   ]
         * [Left    ]
         * [Right   ]
         *
         * Value
         * [Simple Student]
         * [NAME          ]
         * [GPA           ]
         */

        SimpleStudent student;
        Node leftChild;
        Node rightChild;
        Value val;

        public void setVal(val){
            this.val = val;
        }

        /**
         * TODO null out the left and right child.
         * note that Node is inheriting the attributes of Value from the outer class.
         */
        public Node(Value val) {
            this.val = val;
            leftChild = null;
            rightChild = null;
        }
        /**
         * Comments for toString override
         */
        @Override
        public String toString(){
            return "[Name: "+ student.getName() +
                    "GPA: "+ student.getGpa() + "]";
        }
    }
}
/**
 * Souces
 * http://introcs.cs.princeton.edu/java/44st/LinkedListST.java.html
 */