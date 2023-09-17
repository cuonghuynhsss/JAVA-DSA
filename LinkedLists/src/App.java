class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    // Adds an element to the end of the list
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Show list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

class CircularLinkedList {
    private Node head;
    private Node tail;

    public CircularLinkedList() {
        head = null;
        tail = null;
    }

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // Assign newNode's next pointer to itself
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Assign tail's next pointer to head to create a loop
        }
    }

    // Deleta node
    public void deleteNode(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        Node previous = null;

        // Find the Node to delete
        while (current.data != value) {
            if (current.next == head) {
                System.out.println("The value to be deleted was not found.");
                return;
            }
            previous = current;
            current = current.next;
        }

        // Delete Node
        if (current == head && current.next == head) {
            // If the list has only one node
            head = tail = null;
        } else if (current == head) {
            // If the node to be deleted is the first node in the list
            head = current.next;
            tail.next = head;
        } else if (current == tail) {
            // If the node to be deleted is the last node in the list
            tail = previous;
            tail.next = head;
        } else {
            // If the node to be deleted is in the middle of the list
            previous.next = current.next;
        }
    }

    // Print
    public void printList() {
        if (head == null) {
            System.out.println("Empty list.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    // Add Node
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Remove a node from a doubly linked list by value
    public void deleteNode(int value) {
        if (head == null) {
            System.out.println("Empty list.");
            return;
        }

        Node current = head;

        // Find the node to delete
        while (current != null && current.data != value) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("The value to be deleted was not found.");
            return;
        }

        if (current == head && current == tail) {
            // If the list has only one node
            head = tail = null;
        } else if (current == head) {
            // If the node to be deleted is the first node in the list
            head = current.next;
            head.prev = null;
        } else if (current == tail) {
            // If the node to be deleted is the last node in the list
            tail = current.prev;
            tail.next = null;
        } else {
            // If the node to be deleted is in the middle of the list
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    // Print head to tail
    public void printForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Print tail to head
    public void printBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        SinglyLinkedList list = new SinglyLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);

        list.display(); // Résult: 1 -> 2 -> 3 -> null

        CircularLinkedList cll = new CircularLinkedList();

        cll.addNode(1);
        cll.addNode(2);
        cll.addNode(3);
        cll.addNode(4);

        System.out.println("Initial list:");
        cll.printList();

        cll.deleteNode(3); 
        System.out.println("The list after deleting the node has value 3:");
        cll.printList();

        DoublyLinkedList dll = new DoublyLinkedList();

        dll.addNode(1);
        dll.addNode(2);
        dll.addNode(3);
        dll.addNode(4);

        System.out.println("List from start to finish:");
        dll.printForward();

        System.out.println("List from finish to start:");
        dll.printBackward();

        dll.deleteNode(3); 
        System.out.println("List after deleting node with value 3:");
        dll.printForward();
    }
}
