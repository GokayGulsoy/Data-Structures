package treepackage;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T> implements BinaryTreeInterface<T> {

	private BinaryNode<T> root;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(T rootData) {
		root = new BinaryNode<>(rootData);
	}

	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		privateSetTree(rootData, leftTree, rightTree);
	}

	public T getRootData() {
		if (isEmpty()) {
			throw new EmptyTreeException();
		}

		else {
			return root.getData();
		}
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void clear() {
		root = null;
	}

	protected void setRootData(T rootData) {
		root.setData(rootData);
	}

	protected void setRootNode(BinaryNode<T> rootNode) {
		root = rootNode;
	}

	protected BinaryNode<T> getRootNode() {
		return root;
	}

	private void privateSetTree(T rootData, BinaryTree<T> lefTree, BinaryTree<T> righTree) {

		root = new BinaryNode<>(rootData);

		if ((lefTree != null) && (!lefTree.isEmpty())) {
			root.setLeftChild(lefTree.root.copy());
		}

		if ((righTree != null) && (!righTree.isEmpty())) {
			root.setRightChild(righTree.root.copy());
		}

	}

	@Override
	public int getHeight() {

		return root.getHeight();
	}

	@Override
	public int getNumberOfNodes() {

		return root.getNumberOfNodes();
	}

	public void inOrderTraverse() {
		inOrderTraverse(root);
	}

	private void inOrderTraverse(BinaryNode<T> node) {

		if (node != null) {
			inOrderTraverse(node.getLeftChild());
			System.out.println(" 		" + node.getData());
			inOrderTraverse(node.getRightChild());
		}

	}

	public void preOrderTraverse() {
		preOrderTraverse(root);
	}

	private void preOrderTraverse(BinaryNode<T> node) {

		if (node != null) {
			System.out.println(" 		" + node.getData());
			preOrderTraverse(node.getLeftChild());
			preOrderTraverse(node.getRightChild());
		}
	}

	public void postOrderTraverse() {
		postOrderTraverse(root);
	}

	private void postOrderTraverse(BinaryNode<T> node) {

		if (node != null) {
			postOrderTraverse(node.getLeftChild());
			postOrderTraverse(node.getRightChild());
			System.out.println(" 		" + node.getData());
		}
	}

	@Override
	public Iterator<T> getPreOrderIterator() {
		return new PreorderIterator();
	}

	@Override
	public Iterator<T> getPostOrderIterator() {
		return new PostorderIterator();
	}

	@Override
	public Iterator<T> getInorderIterator() {
		return new InorderIterator();
	}

	@Override
	public Iterator<T> getLevelOrderIterator() {
		return new LevelorderIterator();
	}

	@Override
	public void setTree(T rootData) {
		if (rootData != null) {
			root = new BinaryNode<>(rootData);
		}
	}

	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rigthTree) {

		root = new BinaryNode<>(rootData);

		if ((leftTree != null) && (!leftTree.isEmpty())) {
			root.setLeftChild(((BinaryTree<T>) leftTree).root.copy());
		}

		if ((rigthTree != null) && (!rigthTree.isEmpty())) {
			root.setRightChild(((BinaryTree<T>) rigthTree).root.copy());
		}

	}

	private class InorderIterator implements Iterator<T> {

		private Stack<BinaryNode<T>> nodeStack;
		private BinaryNode<T> currentNode;

		public InorderIterator() {
			nodeStack = new Stack<BinaryNode<T>>();
			currentNode = root;
		}

		@Override
		public boolean hasNext() {
			return !nodeStack.isEmpty() || (currentNode != null);
		}

		@Override
		public T next() {

			BinaryNode<T> nextNode = null;

			// Find the leftmost node with no left child
			while (currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			}

			if (!nodeStack.isEmpty()) {

				nextNode = nodeStack.pop();
				currentNode = nextNode.getRightChild();

			}

			else {
				throw new NoSuchElementException();
			}

			return nextNode.getData();
		}
	}

	private class PreorderIterator implements Iterator<T> {

		private Stack<BinaryNode<T>> nodeStack;
		private BinaryNode<T> currentNode;

		public PreorderIterator() {
			nodeStack = new Stack<BinaryNode<T>>();
			currentNode = root;
		}

		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public T next() {

			if (currentNode == null) {
				throw new NoSuchElementException();
			}

			if (nodeStack.isEmpty()) {
				nodeStack.push(currentNode);
			}

			BinaryNode<T> nextNode = nodeStack.pop();
			T dataPortion = nextNode.getData();

			if (nextNode.getRightChild() != null) {
				nodeStack.push(nextNode.getRightChild());
			}

			if (nextNode.getLeftChild() != null) {
				nodeStack.push(nextNode.getLeftChild());
			}

			// We may not have pushed anything. If so, we
			// are at the end, no more nodes to visit
			if (nodeStack.isEmpty()) {
				currentNode = null;
			}

			return dataPortion;
		}

	}

	private class PostorderIterator implements Iterator<T> {

		private Stack<BinaryNode<T>> nodeStack;
		private Stack<Boolean> visitingRightChild;
		private BinaryNode<T> currentNode;

		public PostorderIterator() {
			nodeStack = new Stack<BinaryNode<T>>();
			visitingRightChild = new Stack<Boolean>();
			currentNode = root;
		}

		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public T next() {

			if (currentNode == null) {
				throw new NoSuchElementException();
			}

			if (nodeStack.isEmpty()) {
				// at the beginning of iterator find the leftmost node,
				// pushing all the intermediate nodes onto stack
				pushLeftmostNodeRecord(currentNode);
			}

			// node on the top of the stack is the next one
			// to be visited, unless it has right subtree
			if (nodeStack.peek().getRightChild() == null || visitingRightChild.peek()) {
				T dataPortion = nodeStack.pop().getData();
				visitingRightChild.pop();

				if (nodeStack.isEmpty()) {
					currentNode = null;
				}

				return dataPortion;
			}

			else {
				// now visit the node's right subtree
				// pop false and push true for visiting right child
				if (visitingRightChild.pop()) {
					assert (false);
				}

				visitingRightChild.push(true);
				// now push everyting down to leftmost node
				// in the right subtree
				BinaryNode<T> right = nodeStack.peek().getRightChild();
				pushLeftmostNodeRecord(right);
				// use recursive call to visit that node
				return next();
			}
		}

		private void pushLeftmostNodeRecord(BinaryNode<T> node) {

			// find the leftmost node
			if (node != null) {
				nodeStack.push(node);
				visitingRightChild.push(false);
				pushLeftmostNodeRecord(node.getLeftChild());
			}

		}

	}

	private class LevelorderIterator implements Iterator<T> {

		private Queue<BinaryNode<T>> nodeQueue;
		private BinaryNode<T> currentNode;

		public LevelorderIterator() {
			nodeQueue = new LinkedList<BinaryNode<T>>();
			currentNode = root;
		}

		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public T next() {

			// at the beginning of iterator
			// queue is empty
			if (nodeQueue.isEmpty()) {
				nodeQueue.offer(currentNode);
			}

			BinaryNode<T> nextNode = nodeQueue.poll();
			T dataPortion = nextNode.getData();

			if (nextNode.getLeftChild() != null) {
				nodeQueue.offer(nextNode.getLeftChild());
			}

			if (nextNode.getRightChild() != null) {
				nodeQueue.offer(nextNode.getRightChild());
			}

			// We may not have enqueued anything,
			// in this case we there are no more nodes
			// to visit
			if (nodeQueue.isEmpty()) {
				currentNode = null;
			}

			return dataPortion;
		}
	}

}
