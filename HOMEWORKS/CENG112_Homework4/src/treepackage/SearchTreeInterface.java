package treepackage;

import java.util.Iterator;

public interface SearchTreeInterface<T extends Comparable<? super T>> extends BinaryTreeInterface<T> {

	/**
	 * Searches for a specific entry in this tree
	 * 
	 * @param entry object to be found
	 * @return True if the object was found in the tree
	 */
	public boolean contains(T entry);

	/**
	 * Retrieves a specific entry in this tree
	 * 
	 * @param entry An object to be found
	 * @return Either the object that was found in the tree or null if no such
	 *         object exists
	 */
	public T getEntry(T entry);

	/**
	 * Adds a new entry to this tree, if it does not match an existing object in the
	 * tree. Otherwise, replaces the existing object with the new entry
	 * 
	 * @param newEntry An object to be added to the tree
	 * @return Either null if newEntry was not in the tree already, or the existing
	 *         entry that matched parameter newEntry and has been replaced in the
	 *         tree
	 */
	public T add(T newEntry);

	/**
	 * Remove a specific entry from this tree
	 * 
	 * @param entry An object to be removed
	 * @return Either the object that was removed from the tree, or null if no such
	 *         object exists
	 */
	public T remove(T entry);

	/**
	 * Creates an iterator that traverses all the entries in this tree
	 * 
	 * @return An iterator that provides sequential and ordered access to the
	 *         entries in this tree
	 * 
	 */
	public Iterator<T> getInorderIterator();

}
