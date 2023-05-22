package app.exercise.adt;

import java.util.NoSuchElementException;
import java.util.Iterator;

public class BSTreeIterator<T> implements Iterator<T> {
  Node<T> current, rightMost;

  /**
   * constructor
   * @param b BSTree to iniatialize the iterator with
   */
  public BSTreeIterator(BSTree b) {
		current = b.root;
		rightMost = null;
  }

  /**
   * @return true if next() != null
   */
  @Override
  public boolean hasNext() {
      return current != null;
  }

  /**
   * @return returns next value of the iterator using Morris traversal
   */
	@Override
	public T next() {
		if (!hasNext())
			throw new NoSuchElementException();

		if (current.getLeft() == null) {
			Node<T> temp = current;
			current = current.getRight();
			return temp.getValue();
		}

		rightMost = current.getLeft();

		while (rightMost.getRight() != null && rightMost.getRight() != current)
			rightMost = rightMost.getRight();

		if (rightMost.getRight() == null) {
			rightMost.setRight(current);
			current = current.getLeft();
		}
		else {
			rightMost.setRight(null);
			Node<T> temp = current;
			current = current.getRight();
			return temp.getValue();
		}
		return next();
	}

	/**
	* operation not supported
	*/
	@Override
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Unsupported Operation");
	}
}
