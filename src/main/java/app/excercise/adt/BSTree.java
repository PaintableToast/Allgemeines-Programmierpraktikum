package app.excercise.adt;

import java.util.AbstractCollection;
import java.util.Iterator;

public class BSTree<T extends Comparable<T>> extends AbstractCollection<T> {
    private int size;
    private Node<T> root;
    private BSTreeIterator<T> iterator;
    public BSTree(final Node<T> root) {
        this.root = root;
        this.iterator = new BSTreeIterator<>(root);
    }
    @Override
    public Iterator<T> iterator() {
        return iterator;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    public boolean add(T t) {
        size++;
        return false;
    }
    private void search(final T t) {

    }

    public Node<T> getRoot() {
        return root;
    }

    public boolean remove(Object o) {
        size--;
        return false;
    }
}
