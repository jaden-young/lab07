package lab07;

/**
 * Position interface defined in the book.
 * @author Jaden Young
 */
public interface Position<E> {
    /**
     * Returns the element stored at this position
     * 
     * @return the stored element
     * @throws IllegalStateException if position is no longer valid
     */
    E getElement() throws IllegalStateException;
}
