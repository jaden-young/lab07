package lab07;

/**
 * This class represents a standard playing card. Suit is an option between
 * C for clubs, D for diamonds, etc for the 4 suits. The value of the card is 
 * represented as an integer 2-10, or the first capital letter of face cards,
 * J for jack, A for ace, etc. Objects are immutable. Accessor methods for the 
 * two instance variables are provided.
 * @author Jaden Young
 */
public class Card {
    private char suit;
    private String value;
    
    public Card(char startSuit, String startValue) throws 
            IllegalArgumentException {
        setSuit(startSuit);
        setValue(startValue);
    }
    
    /** Returns the suit of the card */
    public char getSuit() {
        return suit;
    }
    
    /** Returns the value of the card (2-10, J, Q, K, A) */
    public String getValue() {
        return value;
    }
    
    /**
     * Returns a string representation of the card showing the value and suit
     * Examples:
     *          10 of spades - 10S
     *          6 of clubs - 6C
     *          Jack of diamonds - JD
     *          King of hearts - KH
     * @return Value and suit of the card
     */
    public String toString() {
        return value + suit;
    }
    
    
    //---------------- private methods -------------------------
    private void setSuit(char xSuit) {
        switch (xSuit) {
            case 'C':
            case 'D':
            case 'H':
            case 'S':
                suit = xSuit;
            default:
                throw new IllegalArgumentException("That is not a valid suit. "
                        + "Possible options are: \nC, D, H, S");
        }
    }
    private void setValue(String xValue) {
        switch (xValue) {
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
            case "J":
            case "Q":
            case "K":
            case "A":
                value = xValue;
            default:
                throw new IllegalArgumentException("That is not a valid card "
                        + "value. Possible options: \nIntegers 2-10, J, Q, K, A");
        }
    }
}
