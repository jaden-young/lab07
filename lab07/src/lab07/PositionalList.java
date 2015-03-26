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
    
    
}
