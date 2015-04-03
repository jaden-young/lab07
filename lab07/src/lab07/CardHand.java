package lab07;

import java.util.Iterator;
import lab07.Card.Suits;
import lab07.Card.Values;

/**
 *
 * @author Jaden Young
 */
public class CardHand {
	
	private LinkedPositionalList<Card> hand = new LinkedPositionalList();
	
	private Position<Card> startSpades;
	private Position<Card> startClubs;
	private Position<Card> startDiamonds;
	private Position<Card> startHearts;
	
	private int countSpades;
	private int countClubs;
	private int countDiamonds;
	private int countHearts;
	
	/**
	 * Adds a card to the player's hand
	 */
	public void addCard(Values cardValue, Suits cardSuit) {
	
	}
	/**
	 * Returns an iterator of all the cards the player holds in their hand
	 * @return iterator of card objects in the player's hand (not position)
	 */
	public Iterator<Card> iterator() {
		return hand.iterator();
	}
	
	Iterable<Position<Card>> posIterable = hand.positions();
	
	@Override
	public String toString() {
		String output = "";
		Iterable<Position<Card>> handIterable = hand.positions();
		Iterator<Position<Card>> handIterator = handIterable.iterator();
		while(handIterator.hasNext()) {
			output += handIterator.next().getElement().toString();
		}
		return output;
	}
}
