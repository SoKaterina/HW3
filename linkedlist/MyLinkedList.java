package myprogram.linkedlist;

import myprogram.node.Node;
import java.util.Iterator;


public class MyLinkedList<E> implements LinkedList<E>{
    private int size;
    private Node<E> first;
    private Node<E> last;


    public MyLinkedList(){
        first=last=null;
        size = 0;
    }

    public MyIterator<E> iterator(){
        return new MyIterator<E>(0);
    }

    public void add(E element){
        if (size == 0){
            this.first = new Node<E>(null, element,null);
            last= first;
        }
        else {
            final Node<E> l = last;
            final Node<E> newNode = new Node<E>(l, element,null);
            last = newNode;
            l.setNextNode(newNode);
        }
        size++;
    }


    public void add(int index, E element){
        if (index == size)
            add(element);
        else {
            Node<E> m = new Node<E>(getNode(index-1), element, getNode(index-1).getNextNode());
            getNode(index).setPrevNode(m);
            getNode(index-1).setNextNode(m);
        }
        size++;
    }

    public void clear(){
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.getNextNode();
            x.setElement(null);
            x.setNextNode(null);
            x.setPrevNode(null);
            x = next;
        }
        first = last = null;
        size = 0;
    }

    public E get(int index){
        return getNode(index).getElement();
    }

    public int indexOf(E element){
        for (int i = 0; i < size; i++) {
            if (getNode(i).getElement() == element) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index){
        getNode(index-1).setNextNode(getNode(index+1));
        getNode(index+1).setPrevNode(getNode(index-1));
        size --;
        return getNode(index).getElement();
    }

    public E set(int index, E element){
        getNode(index).setElement(element);
        return getNode(index).getElement();
    }

    public int size(){return size;}

    public String toString(){
        String string  = "";
        if(size>0) {
            for (int i = 0; i < size; i++) {
                string = string + getNode(i).toString() + " ";
            }
        }
        else string = "Empty";
        return string;
    }


    public Object[] toArray(){
        Object[] objects = new Object[size];
        int i = 0;
        for (Node<E> x = first; x != null; x = x.getNextNode())
            objects[i++] = x.getElement();
        return objects;
    }


    public <E> E[] toArray(E[] a){
        if(a.length<= size) {
            a = (E[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
            int i = 0;
            Object[] result = a;
            for (Node<E> x = (Node<E>) first; x != null; x = x.getNextNode())
                result[i++] = x.getElement();
        }
        if (a.length > size)
            a[size] = null;

        return a;
    }

    public Node<E> getNode(int index){
        if(index == 0){
            return first;
        }
        else {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.getNextNode();
            return x;
        }
    }

    public class MyIterator<E> implements Iterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;

        public MyIterator(int index){
            next = (index == size) ? null : (Node<E>) getNode(index);
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size();
        }

        @Override
        public E next() {
            if(!(hasNext())){
                System.out.println("it`s final");
                return null;
            }
            else {
                lastReturned = (Node<E>) getNode(nextIndex);
                next =(Node<E>) getNode(nextIndex);
                nextIndex++;
                return lastReturned.getElement();
            }
        }

    }
}
