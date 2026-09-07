import java.io.PrintStream;

public class LinkedList<Q> {
	private Node<Q> head;

	LinkedList(Node<Q> head) {
		this.head = head;
	}

	public Node<Q> getHead() throws NullPointerException {
		if (head == null)
			throw new NullPointerException("List has no head");
		else
			return head;
	}

	protected Node<Q> getHeadUnsafe() {
		return head;
	}

	public Node<Q> get(int i) throws NullPointerException, ArrayIndexOutOfBoundsException {
		if (i < 0)
			throw new ArrayIndexOutOfBoundsException("Not a valid number. List starts at 0");

		return get(getHead(), i);
	}

	public Node<Q> get(Node<Q> node, int i) throws ArrayIndexOutOfBoundsException {
		if (i == 0)
			return node;
		else {
			Node<Q> next = node.getNext();
			if (next == null)
				throw new ArrayIndexOutOfBoundsException("List too short");

			return get(next, i - 1);
		}

	}

	public void insert(Q newValue, int i) throws Exception {
		Node<Q> insertPoint = get(i);

		// Change value, remember old value
		Q oldValue = insertPoint.setValue(newValue);

		// Make a new node with old vale and make it the next node.
		Node<Q> newNode = new Node<Q>(oldValue, insertPoint.getNextUnsafe());
		insertPoint.setNext(newNode);

	}

	public void printAll(PrintStream s) throws NullPointerException {
		printAll(s, getHead());
	}

	public void printAll(PrintStream s, Node<Q> node) {
		System.out.println(node.getValue());

		if (node.getNextUnsafe() != null)
			printAll(s, node.getNext());

	}

	public static void main(String[] args) {
		Node<String> n = new Node<String>("World", null);
		Node<String> m = new Node<String>("Hello", n);

		LinkedList<String> list = new LinkedList<String>(m);

		try {
			list.printAll(System.out);

			list.insert("Karsten's", 3);

			System.out.println("\nNext version:");
			list.printAll(System.out);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
