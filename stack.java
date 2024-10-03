import java.util.EmptyStackException;

public class stack {

    public static void main (String [] args){

        Stack s1 = new Stack();
        String l = "leet**cod*e";

        // Simulate processing of input string with stack
        for(int i = 0; i < l.length(); i++){
            if (l.charAt(i) == '*'){
                s1.pop();
            } else {
                s1.push(l.charAt(i));
            }
        }

        // Use StringBuilder to output remaining stack contents in reverse order
        StringBuilder sb = new StringBuilder();
        while (!s1.isEmpty()){
            sb.append(s1.pop());
        }

        System.out.println(sb.reverse().toString());
    }

    static class Stack {

        private Node head;

        // Singly linked list node
        private class Node {
            private char value;
            private Node next;

            public Node(char value){
                this.value = value;
            }
        }

        // Push a value onto the stack
        public void push (char val){
            Node node = new Node(val);
            node.next = head;
            head = node;
        }

        // Pop a value off the stack
        public char pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            char value = head.value;
            head = head.next;
            return value;
        }

        // Peek at the top value (optional)
        public char peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return head.value;
        }

        // Check if stack is empty
        public boolean isEmpty() {
            return head == null;
        }
    }
}