package lab07;

import java.util.ArrayList;
import java.util.Random;
import lab07.Card.Suits;
import lab07.Card.Values;

/**
 * Creates a standard deck of 52 playing cards.
 * Contains 1 method that removes and returns a card from the deck.
 * (dealing the card out to a player).
 * @author Jaden Young
 */
public class Deck {
	
	private ArrayList<Card> cardDeck = new ArrayList<>();
	/**
	 * Constructs a standard deck of 52 playing cards
	 */
	public Deck() {
		for (Suits suit : Suits.values()) {
			for (Values value : Values.values()) {
				cardDeck.add(new Card(suit, value));
			}
		}
	}
	
	/**
	 * Deals a random card from the deck and removes it from the deck
	 * @return random Card object from the deck
	 */
	public Card card() {
		Random rand = new Random();
		return cardDeck.remove(new Random().nextInt(cardDeck.size()));
	}
	
}
