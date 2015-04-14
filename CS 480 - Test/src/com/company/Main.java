package com.company;

class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class fileIn{
    private String data;
    public String fileIn(String data){
        //TODO get a string data input
        this.data = data;
        return this.data;
    }

    public void reverseCropy(){
        data = fileIn(data);
        //TODO reverse the string of bytes
        //Example: helloWorld >> dlroWolleh
        //TODO must all be done using only pointers through strings.
        for (int i = data.length(); i > data.length(); i--){
            //Note the length of the data string is a malloc
            System.out.print("");
        }
    }
}

class fileOut{
    public void getFileOut(){
        //TODO print out the file's data
    }
}
