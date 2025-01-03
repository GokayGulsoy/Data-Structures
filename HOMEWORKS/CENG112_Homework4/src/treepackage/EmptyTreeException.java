package treepackage;

public class EmptyTreeException extends RuntimeException {

	private static final long serialVersionUID = -8910424681262860702L;

	public EmptyTreeException() {
		super("Tree is empty");
	}
}
