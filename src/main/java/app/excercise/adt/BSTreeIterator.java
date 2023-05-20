package app.excercise.adt;// This class was created by PaintableToast

import java.util.Iterator;

public class BSTreeIterator<T> implements Iterator<T> {
    private Node<T> node;
    public BSTreeIterator(final Node<T> node) {
        this.node = node;
    }
    @Override
    public boolean hasNext() {
        if (node.getLeft() != null || node.getRight() != null)
            return true;
        else return false;
    }

    @Override
    public T next() {
        if (hasNext())
            if (node.getRight() != null)
                return (T) node.getRight().getValue();
            else return (T) node.getLeft().getValue();
        else return null;
    }
    public void remove() {
    }
}
