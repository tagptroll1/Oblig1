package Code;

public class Node<T extends Coin> {
    private T data;
    private Node next;

    Node(T data){
        this(data, null);
    }

    Node(T data, Node next){
        this.data = data;
        this.next = next;
    }
}
