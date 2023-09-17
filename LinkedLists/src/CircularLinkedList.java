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