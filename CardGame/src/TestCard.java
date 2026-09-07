import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class TestCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Card> cards=new ArrayList<Card>();
		cards.add(new Card(Card.Suit.SPADES, Card.K));   // 黑桃 K
        cards.add(new Card(Card.Suit.HEARTS, Card.A));   // 红桃 A
        cards.add(new Card(Card.Suit.CLUBS, 5));         // 梅花 5
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Q)); // 方块 Q
        //Initial order
        System.out.println("Initial order: "+cards);
        
        //AceLowComparator
        Collections.sort(cards,new AceLowComparator());
        System.out.println("If A is the lowest, the order is "+ cards);
        
        Collections.sort(cards,new AceHighComparator());
        System.out.println("If A is the highest, the order is "+ cards);
        
        Collections.sort(cards, new SuitComparator());
        System.out.println("According to the suit, the order is "+ cards);
        
        Hand hand = new Hand();
        hand.addCard(new Card(Card.Suit.HEARTS, Card.A));
        hand.addCard(new Card(Card.Suit.SPADES, Card.K));
        hand.addCard(new Card(Card.Suit.CLUBS, 5));
        hand.addCard(new Card(Card.Suit.DIAMONDS, Card.Q));
        
        System.out.println("Initial order: "+hand);
        
        Card removedCard = hand.removeCard(1);
        System.out.println("Removed card at index 1: " + removedCard);
        System.out.println("Hand after removing one card (" + hand.size() + " left): " + hand);
        
        
	}
	

}
