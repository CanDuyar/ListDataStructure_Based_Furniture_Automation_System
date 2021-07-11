import java.util.Iterator;
import java.util.ListIterator;

/** 
 *  HybridList class implementation
 *  @author CAN DUYAR - 171044075
 * */

public class HybridList < E > {

    /** it keeps an linkedlist that has arraylist as element*/
    private KWLinkedList<KWArrayList<E>> hybridList;
    /**it keeps index value of the hybridlist*/
    private int index = 0;
    /**MAX number of the arraylist of the linkedlist*/
    private static final int MAX_NUMBER = 10;

  /**no parameter constructor*/
  public HybridList() {
    this.hybridList = new KWLinkedList<KWArrayList<E>>();   // initialize new hybrid list
    hybridList.addLast(new KWArrayList<>());
                   
  }

  /**it returns the index value of the hybridlist
    @return index of the hybridlist
  */
    public int getIndex(){
        return index;
    }

/**it adds the element to the lass index
  @param obj object for adding to hybridlist
*/
  public void add(E obj) {

    ListIterator<KWArrayList<E>> it = hybridList.listIterator(index); 
    KWArrayList<E> alist = it.next();

    if(alist.size() == MAX_NUMBER){
        hybridList.addLast(new KWArrayList<>());
        hybridList.getLast().add(obj);
        index++; 
    }
    else
        alist.add(obj);

  }

  /** it removes the element of given index
  @param indx index value to remove a specific index's element
  */
  public void remove(int indx) {

    if(indx >= hybridList.size()){
        System.out.println("out of index!!!");
        return;
    }

    ListIterator<KWArrayList<E>> it = hybridList.listIterator(indx); 
    KWArrayList<E> alist = it.next();


    if(alist.size() == 0){
        index--; 
    }
    else
        it.remove();
  }


/** to reach a specific KWArrayList which is placed in the given index
  * @param ind index value to reach a specific element
  * @return KWArraylist which is reached by iterator's next.
  */
  public KWArrayList<E> get(int ind){

    ListIterator<KWArrayList<E>> it = hybridList.listIterator(ind); 
    return it.next();
}

}



