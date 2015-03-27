package lab07;

/**
 * This class represents a standard playing card. Enums are used for suits and 
 * card values. Suits are hearts, clubs, spades, and diamonds. 
 * Values are two - ten, jack, queen, king, ace. Each has an integer value 
 * associated with it to store the actual card rank (2 is 2, up to ace 
 * being 14). Objects are immutable.
 * @author Jaden Young
 */
public class Card {
    private Suits suit;
    private Values value;
    
	public enum Suits {
		SPADES,
		HEARTS,
		DIAMONDS,
		CLUBS;
	}
	
	public enum Values {
		TWO(2),
		THREE(3),
		FOUR(4),
		FIVE(5),
		SIX(6),
		SEVEN(7),
		EIGHT(8),
		NINE(9),
		TEN(10),
		JACK(11),
		QUEEN(12),
		KING(13),
		ACE(14);
		
		private final int cardValue;
		
		private Values(int newValue) {
			cardValue = newValue;
		}
		
		public int getCardValue() {
			return cardValue;
		}
	}
	
	/**
	 * Creates a new card with a Suit and a card Value
	 * @param startSuit Suit for the card - Spades, hearts, diamonds, or clubs
	 * @param startValue value of the card
	 */
    public Card(Suits startSuit, Values startValue) {
        suit = startSuit;
		value = startValue;
		
    }
    
    /** Returns the suit of the card */
    public Suits getSuit() {
        return suit;
    }
    
    /** Returns the value of the card (2-10, J, Q, K, A) */
    public Values getValue() {
        return value;
    }
    
    /**
     * Returns a string representation of the card showing the value and suit
     * Examples:
     *          10 of Spades
     *          6 of Clubs
     *          Jack of Diamonds
     *          King of Hearts
     * @return Value and suit of the card
     */
	@Override
    public String toString() {
        return value + " of " + suit;
    }
}
