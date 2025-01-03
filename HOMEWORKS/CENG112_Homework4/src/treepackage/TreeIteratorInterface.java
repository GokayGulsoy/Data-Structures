package treepackage;

import java.util.Iterator;

public interface TreeIteratorInterface<T> {

	/**
	 * An interface of traversal methods for a tree
	 */
	public Iterator<T> getPreOrderIterator();

	public Iterator<T> getPostOrderIterator();

	public Iterator<T> getInorderIterator();

	public Iterator<T> getLevelOrderIterator();
}
