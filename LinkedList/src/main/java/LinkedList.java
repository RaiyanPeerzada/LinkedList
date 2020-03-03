import java.util.NoSuchElementException;

/*
    This is a generic class which accepts any type of objects.
    Returns the object in the same format as stored.
    Head - Represents first node in the list
    Tail - Represents last node in the list
    Size - Total number of nodes in the list
 */
public class LinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    // To store node at the passed position
   // private Node<T> positionNode;

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /*
        Initializes with default values
     */
    public LinkedList() {
    }

    /*
        Clear all nodes in the list
     */
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }
    /*
        Returns true if the list is empty, else return false.
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /*
        Adds a new node at the beginning of the list
        element - New element to be added
     */
    public void addFirst(T element){
        Node<T> newNode = new Node<T>(element, null, head);

        if(head == null){
            tail = newNode;
        } else {
            head.setPrevious(newNode);
        }

        head = newNode;
        size++;
    }

    /*
        Adds a new node at the end of the list
        element - New element to be added
     */
    public void addLast(T element){
        Node<T> newNode = new Node<T>(element, tail, null);

        if(tail == null){
            head = newNode;
        } else {
            tail.setNext(newNode);
        }

        tail = newNode;
        size++;
    }

    /*
        Returns the element in the head node
     */
    public T getFirst() {
        if(head == null){
            throw new NoSuchElementException();
        }
        return head.getElement();
    }

    /*
        Returns the element in the tail node
    */
    public T getLast() {
        if( tail == null){
            throw new NoSuchElementException();
        }
        return tail.getElement();
    }

    /*
        Sets the element in the head node
     */
    public T setFirst (T element){
        T oldHeadElement;

        if(head != null) {
           oldHeadElement = head.getElement();
           head.setElement(element);
        } else {
            throw new NoSuchElementException();
        }

        return oldHeadElement;
    }

    /*
        Sets the element in the tail node
    */
    public T setLast(T element){
        T oldTailElement;

        if(tail != null) {
            oldTailElement = tail.getElement();
            tail.setElement(element);
        } else {
            throw new NoSuchElementException();
        }

        return oldTailElement;
    }

    // Milestone 2
    /*
        Removes the head node
     */
    public T removeFirst() {

        if (head == null){
            throw new NoSuchElementException();
        }
        T oldElement = head.getElement();
        if(size == 1) {
            clear();
        } else {
            head = head.getNext();
            head.setPrevious(null);
            size--;
        }
        return oldElement;
    }

    /*
        Removes the tail node
     */
    public T removeLast() {

        if (head == null){
            throw new NoSuchElementException();
        }
        T oldElement = tail.getElement();
        if(size == 1) {
            clear();
        } else {
            tail = tail.getPrevious();
            tail.setNext(null);
            size--;
        }

        return oldElement;
    }

    /*
        Returns the element at the position
     */
    public T get(int position) {
        // Use getNodeByPosition method to get
        return getNodeByPosition(position).getElement();
    }

    /*
        Adds new element after the node at the provided position
     */
    public void addAfter(T element, int position) {
        // If add position is after tail node
        if (position == size) {
            addLast(element);
        } else {
            Node<T> positionNode = getNodeByPosition(position);
            Node<T> nextNode = positionNode.getNext();
            Node<T> newNode = new Node<T>(element, positionNode, nextNode);
            positionNode.setNext(newNode);
            nextNode.setPrevious(newNode);
            size++;
        }
    }

    /*
         Adds new element before the node at the provided position
     */
    public void addBefore(T element, int position) {
        // If add position is before head node
        if (position == 1) {
          addFirst(element);
        } else {
            Node<T> positionNode = getNodeByPosition(position);
            Node<T> nextNode = positionNode;
            Node<T> prevNode = positionNode.getPrevious();
            Node<T> newNode = new Node<T>(element, prevNode, nextNode);

            positionNode.setPrevious(newNode);
            prevNode.setNext(newNode);
            size++;
        }
    }

    /*
        Removes the node at the numeric position specified
     */
    public T remove(int position){
        Node<T> positionNode = getNodeByPosition(position);
        T removeElement = positionNode.getElement();
        if(size == position){
            removeLast();
        } else if(position == 1) {
            removeFirst();
        } else {
            Node<T> prevNode = positionNode.getPrevious();
            Node<T> nextNode = positionNode.getNext();

            prevNode.setNext(nextNode);
            nextNode.setPrevious(prevNode);
            size--;
        }

        return removeElement;
    }

    /*
        Changes the specified node to element in parameter
     */
    public T set(T element, int position){
        Node<T> positionNode = getNodeByPosition(position);
        T currElement = positionNode.getElement();

        if(position == 1){
            setFirst(element);
        } else {
            positionNode.setElement(element);
        }
        return currElement;
    }

    /*
        Returns node at the position from the list
        position - the position to get the node at
     */
    public Node<T> getNodeByPosition (int position){
        if(head == null || position <= 0 || position > size) {
            throw new NoSuchElementException();
        }
        Node<T> positionNode = head;

        int i = 1;
        while (i < position) {
            positionNode = positionNode.getNext();
            i++;
        }
        return positionNode;
    }

    /*
        Milestone 3
     */

    /*
    Compares two elements
     */
    public int compareTwoItems(T obj1, T obj2) {
        // T now has access to compareTo
        return obj1.compareTo(obj2);
    }

    /*
    Gets Node by specified element
     */
    public Node<T> getNodeByElement (T element){
        if(head == null ) {
            throw new NoSuchElementException();
        }

        if(element == null){
            throw new NullPointerException();
        }

        Node<T> elementNode = null;
        Node<T> nextNode = head;
        int i = 0;
        while (i < size && elementNode == null) {
            if (compareTwoItems(nextNode.getElement(), element) == 0) {
                elementNode = nextNode;
            } else {
                nextNode = nextNode.getNext();
            }
            i++;
        }
         if(elementNode == null){
             throw new NoSuchElementException();
         }
         return elementNode;
    }

    /*
    Gets the element in the node containing the element specified
     */
    public T get (T element){
        return getNodeByElement(element).getElement();
    }

    /*
    Adds new element after the node containing the 'oldelement' specified.
     */
    public void addAfter(T element, T oldElement){
        // Retreive the node from the oldElement
        Node<T> elementNode = getNodeByElement(oldElement);

        if(elementNode.getNext() == null){
            addLast(element);
        } else if (elementNode.getPrevious() == null){
            Node<T> nextNode = elementNode.getNext();
            Node<T> newNode = new Node<T>(element, elementNode, nextNode);

            elementNode.setNext(newNode);
            nextNode.setPrevious(newNode);
            size ++;
        }
    }

    /*
    Add new element before the node containing the 'oldelement' specified
     */
    public void addBefore(T element, T oldElement) {
        // Retreive the node from the oldElement
        Node<T> elementNode = getNodeByElement(oldElement);

        if (elementNode.getPrevious() == null) {
            addFirst(element);
        } else if (elementNode.getPrevious() == null) {
            Node<T> prevNode = elementNode.getPrevious();
            Node<T> newNode = new Node<T>(element, prevNode, elementNode);

            elementNode.setPrevious(newNode);
            prevNode.setNext(newNode);
            size++;
        }
    }

    /*
    Removes node with specified element
    <param name="element">Element that is being removed</param>
    <returns>Returns removed element</returns>
     */
    public T remove(T element){
        Node<T> elementNode = getNodeByElement(element);

        if(elementNode.getNext() == null){
            removeLast();
        } else if(elementNode.getPrevious() == null) {
            removeFirst();
        } else {
            Node<T> prevNode = elementNode.getPrevious();
            Node<T> nextNode = elementNode.getNext();

            prevNode.setNext(nextNode);
            nextNode.setPrevious(prevNode);
            size--;
        }

        return elementNode.getElement();
    }

    /*
    Sets element in the specified element node.
     <param name="element">Element that is being set</param>
     <param name="oldElement">Element that is being replaced</param>
     */
    public T set(T element, T oldElement){
        Node<T> elementNode = getNodeByElement(oldElement);
        T currElement = elementNode.getElement();

        if(elementNode.getPrevious() == null){
            setFirst(element);
        } else {
            elementNode.setElement(element);
        }
        return currElement;
    }

    /*
    Insert Element before the element greater than inserting element.
    param - Element that is being inserted
     */
    public void insert(T element){
        Node<T> temp = head;

        while (temp != null && element.compareTo(temp.getElement()) == 1) {
            temp = temp.getNext();
        }

        if (temp == null) {
            addLast(element);
        }
        else {
            if (temp.getPrevious() == null) {
                addFirst(element);
            }
            else {
                Node<T> objectPrevious = temp.getPrevious();
                Node<T> objectNode = new Node<T>(element, objectPrevious, temp);
                temp.setPrevious(objectNode);
                objectPrevious.setNext(objectNode);
                size++;
            }

        }
    }

    /*
    Sort node in ascending order.
     */
    public void sortAscending() {

        if (size >= 2) {
            for (int i = 1; i <= size; i++) {
                Node<T> node = head;
                T temp;
                for (int j = 0; j < size - i; j++) {
                    if (compareTwoItems(node.getElement(), node.getNext().getElement()) == 1 && node.getNext() != null) {
                        temp = node.getNext().getElement();
                        node.getNext().setElement(node.getElement());
                        node.setElement(temp);
                    }
                    node = node.getNext();
                }
            }
        }
    }
}
