package lab07;

/**
 * Positional List ADT, taken straight from the book
 * @param E Data type 
 * @author Jaden Young
 */
public interface PositionalList<E> {
    
    /** Returns the number of elements in the list */
    int size();
    
    /** Tests whether the list is empty */
    boolean isEmpty();
    
    /** Returns the first Position in the list(or null, if empty) */
    Position<E> first();
    
    /** Returns the last Position in the list(or null, if empty) */
    Position<E> last();
    
    /** Returns the position immediately before Position p(null if p is first)*/
    Position<E> before(Position<E> p) throws IllegalArgumentException;
    
    /** Returns the Position immediately after Position p(null if p is last)*/
    Position<E> after(Position<E> p) throws IllegalArgumentException;
    
    /** Inserts element e at the front of the list and returns its Position*/
    Position<E> addFirst(E e);
    
    /** Inserts element e at the back of the list and returns its Position*/
    Position<E> addLast(E e);
    
    /** 
	 * Inserts element e immediately before Position p
	 * @throws IllegalArgumentException if the position is invalid, or the
	 *	element is the wrong data type
	 * @return new Position of added element 
	 */
	Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;
	
	/** 
	 * Inserts element e immediately after Position p
	 * @return new Position of the added element
	 * @throws IllegalArgumentException if the position is invalid, or the 
	 *	element is the wrong data type
	 */
	Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;
	
	/**
	 * Replaces the element stored at Position p, returning replaced element
	 * @return the element being replaced
	 * @throws IllegalArgumentException if the position is invalid, or the 
	 *	element is the wrong data type
	 */
	E set(Position<E> p, E e) throws IllegalArgumentException;
	
	/**
	 * Removes the element stored at Position p and returns it
	 * @return the removed element
	 * @throws IllegalArgumentException if the position is invalid 
	 */
	E remove(Position<E> p) throws IllegalArgumentException;
}
