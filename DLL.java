public class DLL {

    private Node head;
    private int size;

    private class Node{
        private int Vale;
        private Node next;
        private Node previous;

        public Node (int value){
            this.value = vale;
        }

        public Node (int value, Node previous, Node next){
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    public void insertFirst (int val){
        Node node = new Node(val); //create a new node.
        node.previous = null; //this is the first element so whatever enters first will be null.
        node.next = head; //inserts the new node at the front of the linkedlist. remember head is just a pointer to first node.
        if (head != null){
            head.prev = node; //head is the first node. but if null there is nothing there so just skip.
        }
        head = node; //the head and the now first node is pointing to the same item in memory.
        
        
    }
    public void display(){
        Node dis = head;
        Node last;
        while (dis != null){
           print( dis.value + " -> " );
           last = dis;
           dis = dis.next;
        }
    }
    public void revDisplay(){
        while (last != null){
            System.out.println(last.previous);
        }
    }

    
}
