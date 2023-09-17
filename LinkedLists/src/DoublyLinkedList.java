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