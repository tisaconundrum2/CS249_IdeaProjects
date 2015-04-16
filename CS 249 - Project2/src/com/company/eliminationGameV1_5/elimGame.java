package com.company.eliminationGameV1_5;

/**
 * Created by User on 3/23/2015.
 */

class elimGame {
    private Person temp, current, start, end;
    private int size;

    public elimGame(){
        start = null;
        size = 0;
    }

    public void insertPerson(int val){
        //TODO insert a new person
        Person newPerson = new Person();
        newPerson.setiData(val);
        newPerson.setNext(start);
        if (start == null){
            start = newPerson;
            newPerson.setNext(start);
            end = start;
            current = start;
        } else {
            end.setNext(newPerson);
            start = newPerson;
            current = start;
        }
        size++;

    }

    public void closeLoop(){
        //TODO closes the links
        while (!isNull()){
            current = current.next;
        }
        current.next = start;
    }

    public void openLoop() {
        temp = current;
        while (current.next != temp)
            current = current.next;
        temp = current.next;
        current.next = null;
        current = temp;
    }

    //simply displays last person
    public void displayLastPlayer() {
        System.out.print("\n"+current.getiData()+" is the winner!\n");
    }

    //checks if the pointer is == to null
    public boolean isNull(){
        if (current.next == null)
            return true;
        return false;
    }
    //process of getting rid of a player

    //finds the current player
    public void playerLocation(double id) {
        //TODO find the location based on the iData
        //while until found proper iData
        while (id != current.getiData()){
            current = current.next;
        }
    }

    //displays the full list
    public void displayList() {
        while (current != null){
            System.out.printf("[%s] ",current.getiData());
            current = current.next;
        }
        current = temp;
    }

    public void eliminate(int d) {
        for (int i = 0; i < d-1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        start = current.next;
        size--;
    }

    public void display(){
        System.out.print("\nPeople in the Group = ");
        Person ptr = start;
        int flag = 0;
        if (size == 0){
            System.out.print("empty\n");
            return;
        }

        if (size == 1){
            System.out.print("[" +ptr.getiData()+"] ");
        }

        if (size != 1){
            if (ptr.getNext() == ptr){
                System.out.print("["+ptr.getiData()+ "] ["+ptr.getiData()+ "]\n");
                return;
            }

            System.out.print("["+ptr.getiData()+ "] ");
            ptr = ptr.getNext();

            while (ptr.getNext() != start && flag < size - 2){
                System.out.print("["+ptr.getiData()+ "] ");
                ptr = ptr.getNext();
                flag++;
            }
            System.out.print("["+ptr.getiData()+ "] \n");
            ptr = ptr.getNext();
        }
        //System.out.print("["+ptr.getiData()+ "] \n");
    }

    public boolean isClosed(int size) {
        int looped = 0;
        while (!isNull()){
            current = current.next;
            looped++;
            if (looped > size){
                return true;
            }
        }
        return false;
    }
}
