import java.util.Comparator;


public class AceLowComparator implements Comparator<Card> {

	@Override
	public int compare(Card a, Card b) {
		// TODO Auto-generated method stub
		return Integer.compare(a.getRank(), b.getRank());
	}

}
