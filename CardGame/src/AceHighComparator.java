import java.util.Comparator;

public class AceHighComparator implements Comparator<Card>{

	public int getValue(Card card) {
		int rank = card.getRank();
		return (rank==Card.A)?14:rank;
		
	}
	@Override
    public int compare(Card a, Card b) {
        // 拿转换后的权重来比较
        return Integer.compare(getValue(a), getValue(b));
    }

}
