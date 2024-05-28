class linkedList {

    public Link first;

    public linkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }


    public void insertHead(int data) {
        Link newLink = new Link(data);
        newLink.next = first;
        first = newLink;
    }

    public int deleteHead() {
        if (isEmpty()) return -1;
        Link current = first;
        Link temp = current.next;
        int data = current.pop();
        first = temp;
       return data;
    }

    public void display() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }
}

public class Link {
    public int data;
    public Link next;

    public Link(int dataIn) {
        data = dataIn;
    }

    public void displayLink() {
        System.out.println(data);
    }

    public int pop(){
        return data;
    }
}
