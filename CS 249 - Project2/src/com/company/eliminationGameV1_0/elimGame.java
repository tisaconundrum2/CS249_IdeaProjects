package com.company.eliminationGameV1_0;

/**
 * Created by User on 3/13/2015.
 */
public class elimGame {
    private Person start;
    private Person end;
    int size;

    public elimGame(){
        start = null;
        end = null;
        size = 0;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public int getSize() {
        return size;
    }

    public void insertAtStart(String val){
        Person nptr = new Person();
        nptr.setiData(val);
        nptr.setNext(start);
        if (start == null){
            start = nptr;
            nptr.setNext(start);
            end = start;
        } else {
            end.setNext(nptr);
            start = nptr;
        }
        size++;
    }

    public void insertAtEnd(String val){
        Person nptr = new Person(val,null);
        nptr.setNext(start);
        if(start == null){
            start = nptr;
            nptr.setNext(start);
            end = start;
        } else {
            end.setNext(nptr);
            end = nptr;
        }
        size++ ;
    }

    public void insertAtPos(String val , int pos){
        Person nptr = new Person(val,null);
        Person ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++){
            if (i == pos){
                Person tmp = ptr.getNext() ;
                ptr.setNext(nptr);
                nptr.setNext(tmp);
                break;
            }
            ptr = ptr.getNext();
        }
        size++ ;
    }

    public void deleteAtPos(int pos){
        if (size == 1 && pos == 1){
            start = null;
            end = null;
            size = 0;
            return ;
        }
        if (pos == 1){
            start = start.getNext();
            end.setNext(start);
            size--;
            return ;
        }
        if (pos == size){
            Person s = start;
            Person t = start;
        while (s != end) {
                t = s;
                s = s.getNext();
            }
            end = t;
            end.setNext(start);
            size --;
            return;
        }
        Person ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++){
            if (i == pos){
                Person tmp = ptr.getNext();
                tmp = tmp.getNext();
                ptr.setNext(tmp);
                break;
            }
            ptr = ptr.getNext();
        }
        size-- ;
    }

    public void display(){
        System.out.print("\nPeople in the Group = ");
        Person ptr = start;
        if (size == 0){
            System.out.print("empty\n");
            return;
        }

        if (size == 1){
            System.out.print("[" +start.getiData()+"] ");
        }

        if (size != 1){
            if (start.getNext() == start){
                System.out.print("["+start.getiData()+ "] ["+ptr.getiData()+ "]\n");
                return;
            }

            System.out.print("["+start.getiData()+ "] ");
            ptr = start.getNext();
            while (ptr.getNext() != start){
                System.out.print("["+ptr.getiData()+ "] ");
                ptr = ptr.getNext();
            }
            System.out.print("["+ptr.getiData()+ "] \n");
            ptr = ptr.getNext();
        }
        //System.out.print("["+ptr.getiData()+ "] \n");
    }


}
