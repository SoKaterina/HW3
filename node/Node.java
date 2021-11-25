package myprogram.node;

import java.util.LinkedList;

public class Node<E> {
    private E element;
    private Node<E> nextNode;
    private Node<E> prevNode;

    public Node(Node<E> prev, E element, Node<E> next){
        this.element=element;
        this.nextNode = next;
        this.prevNode = prev;
    }


    public void setElement(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void setNextNode(Node<E> nextNode) {
        this.nextNode = nextNode;
    }

    public Node<E> getNextNode() {
        return nextNode;
    }

    public void setPrevNode(Node<E> prevNode) {
        this.prevNode = prevNode;
    }

    public String toString(){
        return element.toString();
    }
}
