package linkedlist;

// Node class for Doubly Linked List
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

// Queue Implementation using Doubly Linked List
class QueueUsingDLL {
    private Node front, rear;
    
    public QueueUsingDLL() {
        this.front = this.rear = null;
    }
    
    // Enqueue operation
    void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        newNode.prev = rear;
        rear = newNode;
    }
    
    // Dequeue operation
    void dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }
        front = front.next;
        if (front != null) {
            front.prev = null;
        } else {
            rear = null; // Queue becomes empty
        }
    }
    
    // Display queue elements
    void display() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// Main class
public class Doubly {
    public static void main(String[] args) {
        QueueUsingDLL queue = new QueueUsingDLL();
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.print("Queue after enqueuing: ");
        queue.display(); // Output: 10 20 30
        
        queue.dequeue();
        System.out.print("Queue after dequeuing: ");
        queue.display(); // Output: 20 30
    }
}
