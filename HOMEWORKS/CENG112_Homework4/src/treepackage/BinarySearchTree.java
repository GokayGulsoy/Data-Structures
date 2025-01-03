package treepackage;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> implements BinaryTreeInterface<T> {

	public BinarySearchTree() {
		super();
	}

	public BinarySearchTree(T rootEntry) {
		super();
		setRootNode(new BinaryNode<T>(rootEntry));
	}

	public void setTree(T rootData) {
		throw new UnsupportedOperationException();
	}

	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		throw new UnsupportedOperationException();
	}

	public T getEntry(T entry) {
		return findEntry(getRootNode(), entry);
	}

	private T findEntry(BinaryNode<T> rootNode, T entry) {
		T result = null;

		if (rootNode != null) {
			T rootEntry = rootNode.getData();

			if (entry.equals(rootEntry)) {
				result = rootEntry;
			}

			else if (entry.compareTo(rootEntry) < 0) {
				result = findEntry(rootNode.getLeftChild(), entry);
			}

			else { // entry.compareTo(rootEntry) >= 0
				result = findEntry(rootNode.getRightChild(), entry);
			}
		}

		return result;
	}

	// method to check whether given entry
	// exists in the BST
	public boolean contains(T entry) {
		return getEntry(entry) != null;
	}

	// method to add a new entry to BST
	public T add(T newEntry) {

		T result = null;

		if (isEmpty()) {
			setRootNode(new BinaryNode<>(newEntry));
		}

		else {
			result = addEntry(getRootNode(), newEntry);
		}

		return result;
	}

	private T addEntry(BinaryNode<T> rootNode, T newEntry) {

		T result = null;
		int comparison = newEntry.compareTo(rootNode.getData());

		if (comparison == 0) {
			result = rootNode.getData();
			rootNode.setData(newEntry);
		}

		else if (comparison < 0) {

			if (rootNode.hasLeftChild()) {
				result = addEntry(rootNode.getLeftChild(), newEntry);
			}

			else {
				rootNode.setLeftChild(new BinaryNode<>(newEntry));
			}
		}

		else {
			assert comparison > 0;

			if (rootNode.hasRightChild()) {
				result = addEntry(rootNode.getRightChild(), newEntry);
			}

			else {
				rootNode.setRightChild(new BinaryNode<>(newEntry));
			}

		}

		return result;
	}

	public T remove(T entry) {

		T oldEntry = null;
		BinaryNode<T> newRoot = removeEntry(getRootNode(), entry, oldEntry);
		setRootNode(newRoot);

		return oldEntry;
	}

	// Removes an entry from the tree rooted at a given node
	// rootNode is a reference to the root of a tree
	// entry is the object to be removed. oldEntry is an
	// object which is initially null
	// Returns the root node of the resulting tree; if entry
	// matches an entry in the tree, oldEntry is the removed
	// entry; otherwise it is null
	private BinaryNode<T> removeEntry(BinaryNode<T> rootNode, T entry, T oldEntry) {

		if (rootNode != null) {

			T rootData = rootNode.getData();
			int comparison = entry.compareTo(rootData);

			if (comparison == 0) {
				oldEntry = rootData;
				rootNode = removeFromRoot(rootNode);
			}

			else if (comparison < 0) {
				BinaryNode<T> leftChild = rootNode.getLeftChild();
				BinaryNode<T> subtreeRoot = removeEntry(leftChild, entry, oldEntry);
				rootNode.setLeftChild(subtreeRoot);
			}

			else {
				BinaryNode<T> rightChild = rootNode.getRightChild();
				BinaryNode<T> subtreeRoot = removeEntry(rightChild, entry, oldEntry);
				rootNode.setRightChild(subtreeRoot);
			}
		}

		return rootNode;
	}

	private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode) {

		// Case 1: rootNode has two children
		if (rootNode.hasLeftChild() && rootNode.hasRightChild()) {
			// Find node with the largest entry in left subtree
			BinaryNode<T> leftSubtreeRoot = rootNode.getLeftChild();
			BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);

			// Replace entry in root
			rootNode.setData(largestNode.getData());

			rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
		}

		// Case 2: rootNode hast at most one child
		else if (rootNode.hasRightChild()) {
			rootNode = rootNode.getRightChild();
		}

		else {
			rootNode = rootNode.getLeftChild();
		}

		return rootNode;
	}

	// Finds the node containing the largest entry in the tree
	// rootNode is the root node of the tree
	// Returns the node containing the largest entry in the tree
	private BinaryNode<T> findLargest(BinaryNode<T> rootNode) {

		if (rootNode.hasRightChild()) {
			rootNode = findLargest(rootNode.getRightChild());
		}

		return rootNode;
	}

	// Removes the node containing the largest entry in a given tree
	// rootNode is the root node of the tree
	// Returns the root node of the revised tree
	private BinaryNode<T> removeLargest(BinaryNode<T> rootNode) {

		if (rootNode.hasRightChild()) {
			BinaryNode<T> rightChild = rootNode.getRightChild();
			rightChild = removeLargest(rightChild);
			rootNode.setRightChild(rightChild);
		}

		else {
			rootNode = rootNode.getLeftChild();
		}

		return rootNode;
	}

}
