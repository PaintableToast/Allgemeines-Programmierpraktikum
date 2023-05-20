package app.excercise.adt;// This class was created by PaintableToast


import app.excercise.visualtree.DrawableTreeElement;

public class Node<T> implements DrawableTreeElement {
    private Node<T> left, right;
    private T value;
    public Node(T value, Node<T> left, Node<T> right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
    public Node(T value) {
        this.value = value;
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
    public Object getValue() {
        return this.value;
    }
}
