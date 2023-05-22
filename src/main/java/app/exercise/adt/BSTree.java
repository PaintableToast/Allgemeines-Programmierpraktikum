package app.exercise.adt;

import java.util.Collection;

/**
 * This class implements the
 */
public class BSTree<T extends java.lang.Comparable<T>> extends java.util.AbstractCollection<T> {
	private int size = 0;
	protected Node<T> root;
	private Node<T> current;
	RedBlackTreeDrawer<T> visual = new RedBlackTreeDrawer<T>();
	
	/**
	* @return iterator instance
	*/
	@Override
	public BSTreeIterator<T> iterator() {
		return new BSTreeIterator<T>(this);
	}
	
	/**
	* @return number of elements in the BSTree
	*/
	@Override
	public int size() { return size; }

	/**
	* @return true if there are no elements in the BSTree
	*/
	@Override
	public boolean isEmpty() { return (size == 0); }

	/**
	* @param o checked if it is contained; o is expected to be of type T
	* @return true if o is contained in the BSTree; otherwise false
	*/
	@Override
	public boolean contains(Object o) {
		current = root;
		for(T val : this)
			if(o.equals(val)) return true;
		return false;
	}

	/**
	* @param tree gets checked if all of tree's Nodes are contained in this BSTree
	* @return false, if this BSTree does not contain a Node from tree
	*/
	@Override
	public boolean containsAll(Collection<?> tree) {
		for(Object val : tree) 
			if(!this.contains(val)) return false;
		return true;
	}

	@Override
	public Object[] toArray() {
		Object[] o = new Object[size];
		int i = 0;
		for(T val : this)
			o[i++] = val;
		return o;
	}

	/**
	* @return returns a String of Elements
	*/
	@Override
	public String toString() {
		String s = new String();
		for(T value : this) 
			s += "[" + value + "], ";

		if (s.length() < 2)
			return s;
		return s.substring(0, s.length()-2);
	}
	
	/**
	* @return smallest value in this BSTree
	*/
	public T getSmallest() {
		current = root;
		while (current.getLeft() != null)
			current = current.getLeft();
		return current.getValue();
	}
	/**
	* @return biggest value in this BSTree
	*/
	public T getBiggest() {
		current = root;
		while (current.getRight() != null)
			current = current.getRight();
		return current.getValue();
	}

	/**
	* function to add a new element to the BSTree object
	* @param t object to be added
	* @return true if value has been added, false if same value was already present before
	*/
	public boolean add(T value) {
		if (this.contains(value)) {
			System.out.println("Same value already added");
			return false;
		}

		size++;
		if (size == 1) {
			root = new Node(value);
			visual.draw(root);
			return true;
		}

		current = root;
		// find first empty spot in tree
		while (true) {
			if (current.getLeft() != null && value.compareTo(current.getValue()) < 0)
				current = current.getLeft();
			else if (current.getRight() != null && value.compareTo(current.getValue()) > 0)
				current = current.getRight();
			else break;
		}

		if (value.compareTo(current.getValue()) < 0)
			current.setLeft(new Node(value));
		else
			current.setRight(new Node(value));

		visual.draw(root);
		return true;
	}	

	public boolean remove(Object o) {
		// nothing to do
		if (!this.contains(o)) return false;
		size--;
		
		current = root;
		for(T val : this) {
			if(o.equals(val)) {
				// wie komme ich an die objekte ran?
			}
		}
		return false;
	}
}
