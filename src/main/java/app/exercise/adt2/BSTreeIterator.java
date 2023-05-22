package app.exercise.adt2;// This class was created by PaintableToast

import java.util.Iterator;

public class BSTreeIterator<T extends Comparable> implements Iterator<T> {
    private Node<T> node, root;
    private BSTree<T> tree;
    public BSTreeIterator(final BSTree<T> tree) {
        this.tree = tree;
        init(tree);
    }
    private void init(final BSTree<T> tree) {
        this.root = tree.getRoot();
        this.node = tree.getRoot();
        while (node.getLeft() != null)
            this.node = (Node<T>) node.getLeft();
    }
    @Override
    public boolean hasNext() {
        System.out.println(node.getValue());
        if (this.node.getValue() != null) {
            System.out.println((this.node.hasRight()) || (this.node.getValue().compareTo(node.getParent().getValue())) == 1);
            return (this.node.hasRight()) || (this.node.getValue().compareTo(node.getParent().getValue())) == 1;
        } else {
            System.out.println("FALSE");
            return false;
        }
    }
    public T getValue() {
        return node == null ? null : node.getValue();
    }
    @Override
    public T next() {
        this.node = hasNext() ? ((this.node.getValue().compareTo(node.getRight().getValue()) == 1) ? (Node<T>) node.getRight() : node.getParent()) : null;
        return getValue();
    }
    public void remove() {
        tree.remove(node);
        init(tree);
    }

}
