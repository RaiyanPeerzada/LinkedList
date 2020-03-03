/*
    This is a generic class
    returns the object in the same format as stored
    @param <T> the type of the value being boxed
 */
public class Node<T> {

    private T element;
    private Node<T> previous;
    private Node<T> next;

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previousNode) {
        this.previous = previousNode;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> nextNode) {
        this.next = nextNode;
    }

    /*
        Initializes with defaults
     */
    public Node() {

    }

    /*
        Initializes Node with element
     */
    public Node(T element) {
        this.element = element;
    }

    /*
        Initializes Node with element, previous node and next node
    */
    public Node(T element, Node<T> previousNode, Node<T> nextNode) {
        this.element = element;
        this.previous = previousNode;
        this.next = nextNode;
    }
}