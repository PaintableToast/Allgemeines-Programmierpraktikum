package app.exercise.adt;

/**
 * This class provides nodes for generic variable types.
 */
public class Node<T> implements app.exercise.visualtree.DrawableTreeElement<T> {

  private Node<T> leftChild, rightChild;
  private T val;

  /**
   * @param val generic object
   */
  public Node(T val) {
    this.val = val;
  }

  /**
   * @return left child of the current node; null if there is no left child
   */
  @Override
  public Node<T> getLeft() {
    return leftChild;
  }

  /**
   * @return right child of the current node; null if there is no right child
   */
  @Override
  public Node<T> getRight() {
    return rightChild;
  }

  /**
   * @return randomly true of false
   */
  @Override
  public boolean isRed() {
    return Math.random() < 0.5;
  }

  /**
   * @return node's generic value
   */
  @Override
  public T getValue() {
    return val;
  }

  /**
   * @param l set as left child
   */
  public void setLeft(Node<T> l) {
    leftChild = l;
  }

  /**
   * @param r set as right child
   */
  public void setRight(Node<T> r) {
    rightChild = r;
  }
}
