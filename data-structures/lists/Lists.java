class Node {
    private String data;
    public Node prev;
    public Node next;

    public Node(String data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public String toString() {
        return this.data;
    }
}

class DoublyLinkedList {
    private Node head;

    public DoublyLinkedList() {

    }
    
    public void insert(String data) {}
    public void remove(String data) {}
    public void push_back(String data) {}
    public void push_front(String data) {}
    public String pop_back() {}
    public String pop_front() {}

    public String toString() {
        Node current = this.head;
        String list = "[";
        while (current != null) {
            list += current.toString();
            current = current.next;
            list += (current != null) ? "," : "";
        }
        list += "]";
        return list;
    }
}

class SinglyLinkedList {
    private Node head;
    
    public SinglyLinkedList() {
        this.head = null;
    }

    public void push_back(String data) {}
    public void push_front(String data) {}
    public String pop_back() {}
    public String pop_front() {}

    public void insert(String data) {
        Node current = this.head;
        
        if (current == null) {
            this.head = new Node(data);
            return ;
        } 

        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public boolean remove(String data) {
        Node current = this.head;
        Node prev = null;
        boolean found = false;
        while (current != null) {
            if (current.toString() == data) {
                if (prev == null) {
                    this.head = current.next;
                } else {
                    prev.next = current.next;
                }
                found = true;
            }
            prev = current;
            current = current.next;
        }
        return found;
    }

    public String toString() {
        Node current = this.head;
        String list = "[";
        while (current != null) {
            list += current.toString();
            current = current.next;
            list += (current != null) ? "," : "";
        }
        list += "]";
        return list;
    }
}

public class Lists {
    
    public static void main(String[] args) {
        SinglyLinkedList l = new SinglyLinkedList();
        l.insert("dude");
        l.insert("sup");
        l.insert("dude");
        l.insert("hey");
        l.insert("dude");
        l.remove("dude");
        System.out.println(l.toString());
    }
}
