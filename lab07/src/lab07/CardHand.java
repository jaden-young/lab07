package lab07;

import java.util.Iterator;
import lab07.Card.Suits;

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
	
	/**
	 * Returns an iterator of all the cards the player holds in their hand
	 * @return iterator of card objects in the player's hand (not position)
	 */
	public Iterator<Card> iterator() {
		return hand.iterator();
	}
	
	/**
	 * Returns an iterator for only the cards of a specific suit
	 * @param suit the suit to create the iterator for 
	 * @return iterator for a specified suit
	 */
	public Iterator<Card> suitIterator(Suits suit) {
		
		Position<Card> startingPosition;
		switch (suit) {
			case SPADES:
				startingPosition = startSpades;
				break;
			case CLUBS:
				startingPosition = startClubs;
				break;
			case DIAMONDS:
				startingPosition = startDiamonds;
				break;
			case HEARTS:
				startingPosition = startHearts;
				break;
			//somethings really up if this happens
			default:
				return null;
		}
		
	}
	
}
