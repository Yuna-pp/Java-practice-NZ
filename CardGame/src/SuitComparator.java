import java.util.Comparator;

public class SuitComparator implements Comparator<Card> {

	@Override
	public int compare(Card a, Card b) {
		// TODO Auto-generated method stub
		return Integer.compare(a.getSuit().ordinal(), b.getSuit().ordinal());
	}

}
