class EmptyContainerException extends Exception {
    public EmptyContainerException(String msg) { super(msg); }
}

interface Displayable { 
    void showDetails(); 
}

abstract class LibraryItem implements Displayable {
    protected String id;
    public LibraryItem(String id) { this.id = id; }
}

class Book extends LibraryItem {
    private String title;
    public Book(String id, String title) { 
        super(id); 
        this.title = title; 
    }
    
    @Override
    public void showDetails() { 
        System.out.println("Book [ID: " + id + ", Title: " + title + "]"); 
    }
}

class Node<T> {
    T data; 
    Node<T> next;
    Node(T data) { this.data = data; }
}

class GenericStack<T> {
    private Node<T> top;

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
    }

    public T pop() throws EmptyContainerException {
        if (top == null) throw new EmptyContainerException("Stack is empty! Cannot pop.");
        T poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    public void displayAll() {
        Node<T> temp = top;
        while (temp != null) {
            if (temp.data instanceof Displayable) {
                ((Displayable) temp.data).showDetails();
            }
            temp = temp.next;
        }
    }
}

class Repository<T extends LibraryItem> {
    private GenericStack<T> storage = new GenericStack<>();
    
    public void add(T item) { storage.push(item); }
    public void showInventory() { storage.displayAll(); }
    public T removeLast() throws EmptyContainerException { return storage.pop(); }
}

public class Main {
    public static void main(String[] args) {
        Repository<Book> library = new Repository<>();
        
        library.add(new Book("B01", "Java Concurrency"));
        library.add(new Book("B02", "Effective Java"));

        System.out.println("--- Library Inventory ---");
        library.showInventory();

        try {
            System.out.println("\n--- Removing item ---");
            Book removed = library.removeLast();
            System.out.print("Removed: ");
            removed.showDetails();
            
            library.removeLast();
            library.removeLast(); 
        } catch (EmptyContainerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
