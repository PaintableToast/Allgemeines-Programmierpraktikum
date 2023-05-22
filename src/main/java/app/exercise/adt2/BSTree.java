package app.exercise.adt2;

import java.util.AbstractCollection;
import java.util.Iterator;

public class BSTree<T extends Comparable> extends AbstractCollection<T> {
    private int size;
    private Node<T> root, current;
    private T current_value, object_value;
    private BSTreeIterator<T> iterator;
    public BSTree(final Node<T> root) {
        this.root = root;
        size = 1;
    }
    @Override
    public Iterator<T> iterator() {
        iterator = new BSTreeIterator<>(this);
        return iterator;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        current = root;
        if (o instanceof Node<?>) {
            object_value = (T) ((Node<?>) o).getValue();
            while (current != null && object_value != null) {
                current_value = current.getValue();
                if (current_value.compareTo(object_value) == 0)
                    return true;
                current = (Node<T>) (current_value.compareTo(object_value) < 0 ? current.getLeft() : current.getRight());
            }
        }
        return false;
    }

    public boolean add(T t) {
        boolean right = true, execute = true;
        if (this.contains(new Node(t))) return false;
        current = root;
        while (execute) {
            current_value = current.getValue();
            if (current_value == null) return false;
            right = current_value.compareTo(t) == 1;
            execute = right ? current.hasRight() : current.hasLeft();
            if (execute) current = (Node) (right ? current.getRight() : current.getLeft());
        }
        System.out.println(current.getValue());
        if (!right) current.setRight(new Node<>(t, current));
        else current.setLeft(new Node<>(t, current));
        size++;
        return true;
    }

    public Node<T> getRoot() {
        return root;
    }

    public boolean remove(Object o) {
        Node<T> remove_node = null;
        if (o instanceof Node<?>)
            if (this.contains(o)) {
                current = root;
                boolean remove_search = true;
                object_value = (T) ((Node<?>) o).getValue();
                while (remove_search) {
                    current_value = current.getValue();
                    if (current_value.compareTo(object_value) == 0) remove_node = current;
                    remove_search = (current_value.compareTo(object_value)) < 0 ? current.getLeft() != null : current.getRight() != null;
                    current = (Node<T>) (((current_value.compareTo(object_value)) < 0) && remove_search ? current.getLeft() : current.getRight());
                }
                if (remove_node != null) {
                    remove_node.setValue(current.getValue());
                    if (current.getParent().getLeft().equals(current)) current.getParent().setLeft(null);
                    else current.getParent().setRight(null);
                    size--;
                    return true;
                }
            }
        return false;
    }
    @Override
    public Object[] toArray() {
        Object[] t = new Object[size];
        int count = 0;
        iterator();
        for (BSTreeIterator<T> iterator = this.iterator; iterator.hasNext(); iterator.next()) {
            t[count] = iterator.getValue();
            count++;
        }
        return t;
    }
}
