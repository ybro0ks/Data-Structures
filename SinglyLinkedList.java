import java.util.*;
public class play {

    private Node head; //pointers that point to the node
    private Node tail; //pointers that point to the tail

    private int size; // size of the linked list

    public play(){ // initialises the linked list.
        this.size = 0;
    }

    // this is what every node needs to look like inside the internal linked list implementation.

    private class Node{ //constructor for the node. its private no access
        private int value; //private no access. only internal
        private Node next; //private no access

        
     public Node (int value){ //publlic can be accessed to add new value
        this.value = value;
     }

     public Node(int value, Node next) { 

        this.value = value;
        this.next = next;
     }
    }

    public void insertFirst(int val){
        Node node = new Node(val); //first create a new node.
        node.next = head; // point the node to the head
        head = node; //now point the head to the node. now both point to each other

        if (tail == null) { //if nothing exists at the tail. the tail is equal to the head
            tail = head;
        }

        size += 1; //add one to the size tracker of the node.
    }

    public void insertLast(int val){  //insert last element
        if(tail == null) { // if tail is nul as in theres nothing at the end. no element
            insertFirst(val); //call this function instead
            return;
        }
        // this could be in an else condition but java will automatically move down anyways.

        Node node = new Node(val); //else we create the first node.
        tail.next = node; //point it to the next.
        tail = node; // tail == node as in the tail is now the node
        size++;
    }

    public int deleteFirst() {
        int val = head.value;v//store the value in head.value so you can use it.
        head = head.next;
        if (head == null){ //head == null then theres nothing at null too.
            tail = null;
        }
        size--; //size goes down to one
        return val; //in case we want to test it out and see what was removed.
    }

    public int deleteLast(){
        if (size <= 1){
            return deleteFirst(); //if the size of the linked list is 0 it means we can just use our previous function
        }

        Node secondLast = get(size - 2); //we have a get function that finds the node just before the last node.
        int val = tail.value; // this current tail holds the value we might want to return after it is deleted so we store it in a temporary variable called val for later use.
        tail = secondLast; // the node the get function returned becomes the last node.
        tail.next = null; // we disconnect the last node for the garbage collector to consume.
    }


    public void display(){ //display
        Node temp = head; // if we use this we dont change the structure.
        while (temp != null) { // we now move the temp forward
            System.out.print(temp.value + " linked to "); //print value and what its linked to
            temp = temp.next; //then temp.next basically move on to the next.
        }
        System.out.println("The loop is finished."); //now the loop is finished. the end.
    }


    public void insert(int val, int index){
        //insert a value at a particular index

        if (index == 0){
            insertFirst(val);
            return;
        }
        if (index == size){
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++){
            temp = temp.next; // we assigned the temp to temp.next and simply moved it up.
        }

        Node node = new Node(val, temp.next); // now we know what index we want to use and the node value thats where this comes in
        temp.next = node;
    //just want to write some code before o [a]
    }

    
}
