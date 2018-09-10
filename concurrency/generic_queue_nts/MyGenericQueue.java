package queue;

/** Implementation of a FIFO Queue of Items.
*  Uses a singly-linked list to keep contents.
*  @NOTTHREADSAFE
*/
class MyGenericQueue <T> implements FifoQueue <T>{

   private static class Element <T>{ // this needs to be static!
      /* this is really just like a C/C++ struct */
      T item;
      Element next;
      Element(T i) {
         this.item = i;
         this.next = null;
      }
   } //end Element class

   private Element first;
   private Element last;
   private int length;

   /* Invariants:
   *   - (first==null) == (last==null)
   *   - length is the number of elements in the list
   *   - list contains all values passed to enq() minus all non-null
   *         values returned by deq()
   *   - first points to the first Item enqueued, not yet dequeued.
   *   - length==1 => first==last
   *   - the order of elements in the list is the order they were enqueued
   */

   public MyGenericQueue() {
      this.first = null;
      this.last = null;
      this.length = 0;
   }

   public void enqueue(T item) {    // note: never fails
      Element e = new Element(item);

      if (this.last==null) { // if empty
         this.first = e;
         this.last = e;
      } else { // nonempty
         this.last.next = e;
         /* e.next == null */
         this.last = e;
      }

      this.length += 1;
   }

 
   public T dequeue() {   // returns null if empty

      if (this.first==null){
         return null;
      } else { /* this.first != null */
         T r = (T) this.first.item;
         this.first = this.first.next;
         if (this.first==null) {// now empty
            this.last = null;
         }
         this.length -= 1;
         return r;
      } // else

   }
  
   public boolean isEmpty() { //true if nothing in queue
      return this.first==null;
   }

   public int getQueueLength() { // returns number currently in queue
      return this.length;
   }

}  

    
