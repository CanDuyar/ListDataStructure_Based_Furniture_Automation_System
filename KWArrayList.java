import java.util.Iterator;
import java.util.ListIterator;

/** 
*   @author CAN DUYAR - 171044075 
*   KWArrayList class(from the book).
*/

public class KWArrayList < E > {
  
  /*max capacity of arraylist*/
  private static final int MAX_NUMBER = 100;

  /** data array to keep elements of the arraylist */
  private E[] theData;

  /** size of the arraylist */
  private int size = 0;

  /** The current capacity */
  private int capacity = 0;

  /** no parameter constructor 
   */

  @SuppressWarnings("unchecked")
  public KWArrayList() {
    capacity = MAX_NUMBER;
    theData = (E[])new Object[capacity];
  }

  /**   
    *  @param anEntry it adds an element as last element 
    *  to add an element to arraylist
   */
  public boolean add(E anEntry) {
    if (size == capacity) {
      reallocate();
    }
    theData[size] = anEntry;
    size++;
    return true;
  }

  /**   Get a value in the array based on its index.
        @param index - The index of the item desired
        @throws ArrayIndexOutOfBoundsException - if the index
        is negative or if it is greater than or equal to the
        current size
   */
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException(index);
    }
    return theData[index];
  }

  /**   Set the value in the array based on its index.
        @param index - The index of the item desired
        @param newValue - The new value to store at this position
        @return The old value at this position
        @throws ArrayIndexOutOfBoundsException - if the index
        is negative or if it is greater than or equal to the
        current size
   */
  public E set(int index, E newValue) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException(index);
    }
    E oldValue = theData[index];
    theData[index] = newValue;
    return oldValue;
  }

  /** Remove an entry based on its index
        @param index - The index of the entry to be removed
        @return The value removed
        @throws ArrayIndexOutOfBoundsException - if the index
        is negative or if it is greater than or equal to the
        current size
   */
  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException(index);
    }
    E returnValue = theData[index];
    for (int i = index + 1; i < size; i++) {
      theData[i - 1] = theData[i];
    }
    size--;
    return returnValue;
  }

  /** Allocate a new array
   */
   @SuppressWarnings("unchecked")
  private void reallocate() {
    capacity = 2 * capacity;
    E[] newData = (E[])new Object[capacity];
    System.arraycopy(theData, 0, newData, 0, size);
    theData = newData;
  }

  /** Get the current size of the array
        @return The current size of the array
   */
  public int size() {
    return size;
  }

  public void show(){
    for(int t = 0; t < size; t++)
      System.out.print(" " + theData[t]);
  }


 @SuppressWarnings("unchecked")
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < size) return;

        E[] old = theData;
        theData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theData[i] = old[i];
        }
    }

    public void add(int index, E element) {
        if (theData.length == size()) ensureCapacity(size() * 2 + 1);
        for (int i = size; i > index; i--) {
            theData[i] = theData[i - 1];
        }
        theData[index] = element;
        size++;
    }

 
}
