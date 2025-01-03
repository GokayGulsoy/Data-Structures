package treepackage;

public interface TreeInterface<T> {

	/**
	 * An interface of methods common to all trees
	 */
	public T getRootData();

	public int getHeight();

	public int getNumberOfNodes();

	public boolean isEmpty();

	public void clear();

}
