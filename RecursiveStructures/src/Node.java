
public class Node<T> {
	private T value;
	private Node<T> next;

	Node(T value, Node<T> next) {
		this.value = value;
		this.next = next;
	}

	/** Set new value, return the old value */
	public T setValue(T value) {
		T oldValue = this.value;
		this.value = value;
		return oldValue;
	}

	public T getValue() {
		return value;
	}

	public boolean hasNext() {
		return next != null;
	}

	public Node<T> getNext() throws NullPointerException {
		if (next == null)
			throw new NullPointerException("List ended");

		return next;
	}

	protected Node<T> getNextUnsafe() {
		return next;
	}

	/** Set new next, return the old next */
	public Node<T> setNext(Node<T> newNext) {
		Node<T> oldNext = next;
		next = newNext;

		return oldNext;
	}
	
	/** Get the Node i places away from this one */
	public Node<T> getAt(int i) {
		if (i == 0)
			return this;
		return next.getAt(i - 1);
	}

	
}
