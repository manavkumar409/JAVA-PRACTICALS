class Node<T> {
    T data;
    Node<T> next;
    Node(T data) { this.data = data; }
}

class GenericList<T> {
    private Node<T> head;
    private int size = 0;

    void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) head = newNode;
        else {
            Node<T> temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
        size++;
    }

    void delete(T key) {
        Node<T> temp = head, prev = null;
        if (temp != null && temp.data.equals(key)) {
            head = temp.next; size--; return;
        }
        while (temp != null && !temp.data.equals(key)) {
            prev = temp; temp = temp.next;
        }
        if (temp == null) return;
        prev.next = temp.next; size--;
    }

    boolean search(T key) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(key)) return true;
            temp = temp.next;
        }
        return false;
    }

    void traverse() {
        Node<T> temp = head;
        while (temp != null) { System.out.print(temp.data + " -> "); temp = temp.next; }
        System.out.println("null");
    }

    int size() { return size; }
    boolean isEmpty() { return head == null; }
}

public class Main {
    public static void main(String[] args) {
        // Testing with Integer
        GenericList<Integer> intList = new GenericList<>();
        intList.insert(10); intList.insert(20); intList.insert(30);
        intList.delete(20);
        System.out.print("Integer List: "); intList.traverse();
        System.out.println("Search 30: " + intList.search(30));

        // Testing with String
        GenericList<String> strList = new GenericList<>();
        strList.insert("Java"); strList.insert("Python");
        System.out.print("String List: "); strList.traverse();
        System.out.println("Size: " + strList.size() + " | Empty? " + strList.isEmpty());
    }
}

