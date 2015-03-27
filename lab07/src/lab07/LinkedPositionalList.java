package lab07;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Standard LinkedPositionalList class ripped straight from the book. 
 * @author Jaden Young
 */
public class LinkedPositionalList<E> implements PositionalList<E> {
	
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
		
		/**
		 * Returns the element stored inside the node
		 * @return The element stored in the node
		 * @throws IllegalStateException if the position is invalid
		 */
		@Override
		public E getElement() throws IllegalStateException {
			if (next == null)
				throw new IllegalStateException("Position is not valid");
			return element;
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
	
	private final Node<E> head;
	private final Node<E> tail;
	private int size = 0;
	
	/**
	 * Constructs a new empty list
	 */
	public LinkedPositionalList() {
		head = new Node<>(null, null, null);
		tail = new Node<>(null, head, null);
		head.setNext(tail);
	}
	
	// -------------------------- private methods ------------------
	//validates the position and returns it as a node
	private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if(!(p instanceof Node)) throw new IllegalArgumentException("Invalid "
				+ "position.");
		Node<E> node = (Node<E>) p;
		if(node.getNext() == null)
			throw new IllegalArgumentException("That position is no longer "
					+ "part of the list");
		return node;
	}
	
	//returns the given node as a Position (or null, if it is a sentinal)
	private Position<E> position(Node<E> node) {
		if (node == head || node == tail)
			return null; //return null to hide the sentinals
		return node;
	}
	
	// ---------------------- public accessor methods ---------------------
	/**
	 * Returns the size of the list
	 * @return number of elements in the list
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * Tells if the list is empty
	 * @return true if there are no elements in the list, false if there are
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Returns the first Position object in the list (or null, if empty)
	 * @return first position object in the list
	 */
	@Override
	public Position<E> first() {
		return head.getNext();
	}
	
	/**
	 * Returns the last Position object in the list (or null, if empty)
	 * @return last Position object in the list
	 */
	@Override
	public Position<E> last() {
		return tail.getPrevious();
	}
	
	/**
	 * Returns the Position object immediately before the specified position
	 * <BR> Returns null if the position is the first
	 * @param position the object before this in the list will be returned
	 * @return Position before the specified position (null if first)
	 * @throws IllegalArgumentException if the argument passed is not the 
	 *	correct type or if that position does not exist
	 */
	@Override
	public Position<E> before(Position<E> position) 
			throws IllegalArgumentException {
		Node<E> tempNode = validate(position);
		return position(tempNode.getPrevious());
	}
	
	/**
	 * Returns the Position object immediately following the specified position
	 * <BR> Returns null if the position is the last in the list
	 * @param position the object after this in the list will be checked
	 * @return Position after the specified position (null if last)
	 * @throws IllegalArgumentException if the argument passed is not the 
	 *	correct type or if that position does not exist
	 */
	@Override
	public Position<E> after(Position<E> position) 
			throws IllegalArgumentException {
		Node<E> tempNode = validate(position);
		return position(tempNode.getNext());
	}
	
	/**
	 * Removes the specified Position object and returns the element contained 
	 * in it.
	 * @param position The Position object to be removed
	 * @return the element stored in the removed Position object
	 * @throws IllegalArgumentException if the position is invalid
	 */
	@Override
	public E remove(Position<E> position) {
		Node<E> tempNode = validate(position);
		Node<E> predacessor = tempNode.getPrevious();
		Node<E> successor = tempNode.getNext();
		predacessor.setNext(successor);
		successor.setPrevious(predacessor);
		size--;
		E removedElement = tempNode.getElement();
		tempNode.setElement(null);
		tempNode.setPrevious(null);
		tempNode.setNext(null);
		return removedElement;
	}
	
	// adds element e to the list between given nodes
	private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
		Node<E> newest = new Node<>(e, pred, succ);
		pred.setNext(newest);
		succ.setPrevious(newest);
		size++;
		return newest;
	}
	
	// --------------------- public mutator methods ------------------------
	/**
	 * Adds an element to the front of the list, creating a new position object
	 * to house it
	 * @param element element to be added
	 * @return the added Position object encapsulating the element
	 */
	@Override
	public Position<E> addFirst(E element) {
		return addBetween(element, head, head.getNext());
	}
	
	/**
	 * Adds an element to the back of the list, creating a new position object
	 * to house it
	 * @param element element to be added
	 * @return the added Position object
	 */
	@Override
	public Position<E> addLast(E element) {
		return addBetween(element, tail.getPrevious(), tail);
	}
	
	/**
	 * Inserts an element to the list immediately before the specified position
	 * @param position The position to be added before
	 * @param element The element to store in the new position object
	 * @return the Position object created by the insertion
	 * @throws IllegalArgumentException if the position does not exist
	 */
	@Override
	public Position<E> addBefore(Position<E> position, E element) 
			throws IllegalArgumentException {
		Node<E> tempNode = validate(position);
		return addBetween(element, tempNode.getPrevious(), tempNode);
	}
	
	/**
	 * Inserts an element to the list immediately after the specified position
	 * @param position The position to be added after
	 * @param element The element to be stored in the new position object
	 * @return The Position object created by the insertion
	 * @throws IllegalArgumentException if the position does not exist
	 */
	@Override
	public Position<E> addAfter(Position<E> position, E element) 
			throws IllegalArgumentException {
		Node<E> tempNode = validate(position);
		return addBetween(element, tempNode, tempNode.getNext());
	}
	
	/**
	 * Sets the element in a specified position object to a new value.
	 * Returns the replaced element
	 * @param position The position object that is to be modified
	 * @param element The new value for the element
	 * @return The element that has been replaced
	 * @throws IllegalArgumentException if the Position object does not exist
	 */
	@Override
	public E set(Position<E> position, E element) 
			throws IllegalArgumentException {
		Node<E> tempNode = validate(position);
		E replacedElement = tempNode.getElement();
		tempNode.setElement(element);
		return replacedElement;
	}
	
	//---------------------- nested PositionIterator class ------------------
	private class PositionIterator implements Iterator<Position<E>> {
		private Position<E> cursor;
		private Position<E> recent = null;
		
		public PositionIterator() {
			cursor = first();
		}
		
		public PositionIterator(Position<E> startingPosition) {
			cursor = startingPosition;
		}
	
		/**
		 * Tests whether the iterator has a next object
		 * @return True if there is another object after, false if not
		 */
		@Override
		public boolean hasNext() {
			return cursor != null;
		}
		
		/**
		 * Returns the next position in the iterator
		 * @return the next position object in the iterator
		 * @throws NoSuchElementException if the iterator has reached the end of
		 *	the list
		 */
		@Override
		public Position<E> next() throws NoSuchElementException {
			if (cursor == null) throw new NoSuchElementException("There are no "
					+ "more elements in the list.");
			recent = cursor;
			cursor = after(cursor);
			return recent;
		}
		
		/**
		 * Removes the element returned by the most recent call to the next() 
		 * method
		 * @throws IllegalStateException if there is nothing left to remove
		 */
		@Override
		public void remove() throws IllegalStateException {
			if (recent == null) throw new IllegalStateException("There is "
					+ "nothing left to remove.");
			LinkedPositionalList.this.remove(recent);
			recent = null;
		}
	} //---------------- end of nested PositionIterator class ----------------
	
	// ----------------- nested PositionIterable class -----------------------
	private class PositionIterable implements Iterable<Position<E>> {
		@Override
		public Iterator<Position<E>> iterator() {
			return new PositionIterator();
		}
		
//		public Iterator<Position<E>> iterator(Position<E> startingPosition) {
//			return new PositionIterator(startingPosition);
//		}
	} //--------------- end of nested PositionIterable class ----------------- 
	
	/**
	 * Returns an iterable representation of the list's positions
	 * @return iterable of the list's positions 
	 */
	public Iterable<Position<E>> positions() {
		return new PositionIterable();
	}
	
//	/**
//	 * Returns an iterator representation of the list's positions from a 
//	 * specified starting point
//	 * @param startingPosition Position for the start of the iterator
//	 * @return iterator of the lists positions from a given starting point
//	 */
//	public Iterator<Position<E>> positions(Position<E> startingPosition) {
//		return new PositionIterator(startingPosition);
//	}
	
	//---------------- nested ElementIterator class --------------------------
	private class ElementIterator implements Iterator<E> {
		Iterator<Position<E>> posIterator = new PositionIterator();
		
		/**
		 * Returns true if there is a next item, false if not
		 * @return True if there is a next item, false if not
		 */
		@Override
		public boolean hasNext() {
			return posIterator.hasNext();
		}
		
		/**
		 * Returns the element stored in the next position
		 * @return the element stored in the next position
		 */
		@Override
		public E next() {
			return posIterator.next().getElement();
		}
		
		/**
		 * Removes the element returned by the most recent call the the next()
		 * method
		 * @throws IllegalStateException if there is nothing left to remove
		 */
		@Override
		public void remove() {
			posIterator.remove();
		}
	} // -------------- end of nested ElementIterator class ------------------
	
	//finally......
	/**
	 * Returns an iterator for the elements stored in the list 
	 * @return an iterator that transverses the elements in the list
	 */
	public Iterator<E> iterator() {
		return new ElementIterator();
	}
}
