
public class Card {
	
	public enum Suit{
		CLUBS,
		DIAMONDS, 
		HEARTS, 
		SPADES
	}
	
	public static final int A=1;
	public static final int J=11;
	public static final int Q=12;
	public static final int K=13;
	
	private final Suit suit;
    private final int rank;
		
	public Card(Suit suit,int rank) {
		this.suit=suit;
		this.rank = rank;
		
	}

	public Suit getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
	@Override
	public String toString() {
		String rankStr = switch (rank) {
        case A -> "A";
        case J -> "J";
        case Q -> "Q";
        case K -> "K";
        default -> String.valueOf(rank);
    };
    return rankStr + " of " + suit;
    }
			
}
