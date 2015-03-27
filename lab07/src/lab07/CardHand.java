package lab07;

/**
 *
 * @author Jaden Young
 */
public class CardHand<E> implements PositionalList {
	
	//------------------- nested Node class ----------------------------
	private static class Node<E> implements Position<E> {
		private E element;
		private Node<E> prev;
		private Node<E> next;
		
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}
		
		public Node<E> getPrevious() {
			return prev;
		}
		
		public Node<E> getNext() {
			return next;
		}
		
		public void setElement(E e) {
			element = e;
		}
		
		public void setPrevious(Node<E> p) {
			prev = p;
		}
		
		public void setNext(Node<E> n) {
			next = n;
		}
	} //-------------- end of nested Node class ------------------------
	
	private int size = 0;
	
	/** Returns the number of elements in the list */
    public int size() {
		return size;
	}
    
    /** 
	 * Tests whether the list is empty 
	 * @return true if the list is empty, false if not
	 */
    public boolean isEmpty() {
		return size == 0;
	}
    
    /** 
	 * Returns the first Position in the list(or null, if empty) 
	 * @return the first Position object in the list
	 */
    public Position<E> first(){
		
	}
    
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
	E remove(Position<E> p) throws IllegalArgumentExcep
    
}
