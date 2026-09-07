
public class Train<T> {
	private Wagon<T> head;
	
	public Train() {
        this.head = null;
    }

    public Wagon<T> getHead() {
        return head;
    }
    public void setHead(Wagon<T> head) {
        this.head = head;
    }
    
    public void prepend(T x) {
    	Wagon<T> newWagon=new Wagon<>(x);
    	prepend(newWagon);
    }
    
    public void prepend(Wagon<T> newWagon) {
        if (newWagon == null) return;
        newWagon.setNext(this.head);
        this.head = newWagon;
    }
}
