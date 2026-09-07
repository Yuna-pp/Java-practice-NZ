import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Hand {
	private final List<Card> cards;
	
	
	public Hand() {
		this.cards = new ArrayList<>();
    }
	
	
	
	public void addCard(Card card) {
        cards.add(card);
    }
	
	
	public Card removeCard(int index) {
        return cards.remove(index);
    }
	
	
	public int size() {
        return cards.size();
    }
	public Card getCard(int index) {
        return cards.get(index);
    }
	
	public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }
	
	public void sort(Comparator<Card> comparator) {
        Collections.sort(cards, comparator);
    }
	
	@Override
    public String toString() {
        return cards.toString();
    }
	
}
