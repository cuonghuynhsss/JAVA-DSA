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
