package app.exercise.adt2;// This class was created by PaintableToast


import app.exercise.visualtree.DrawableTreeElement;

public class Node<T extends Comparable> implements DrawableTreeElement {
    private Node<T> left, right, parent;
    private T value;
    public Node(T value,Node<T> parent, Node<T> left, Node<T> right) {
        this.left = left;
        this.right = right;
        this.value = value;
        this.parent = parent;
    }
    public Node(T value,Node<T> parent) {
        this.value = value;
        this.parent = parent;
    }
    public boolean hasRight() {
        return this.right != null;
    }
    public boolean hasLeft() {
        return this.left != null;
    }
    public Node(T value) {
        this.value = value;
    }
    public Node<T> getParent() {
        return this.parent;
    }
    public void setParent(Node<T> parent) {
        this.parent = parent;
    }
    public void setLeft(final Node<T> left) {
        this.left = left;
    }
    public void setRight(final Node<T> right) {
        this.right = right;
    }
    public void setValue(final T value) {
        this.value = value;
    }
    @Override
    public DrawableTreeElement getLeft() {
        return this.left;
    }
    @Override
    public DrawableTreeElement getRight() {
        return this.right;
    }
    @Override
    public boolean isRed() {
        return Math.random() < 0.5;
    }
    @Override
    public T getValue() {
        return this.value;
    }
}