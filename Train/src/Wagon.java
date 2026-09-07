
public class Wagon<Q> {
	private Q value;
    private Wagon<Q> next;
    
    public Wagon(Q value) {
        this.value = value;
        this.next = null;
    }

	public Q getValue() {
		return value;
	}

	public void setValue(Q value) {
		this.value = value;
	}

	public Wagon<Q> getNext() {
		return next;
	}

	public void setNext(Wagon<Q> next) {
		this.next = next;
	}
    
}
