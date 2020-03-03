// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

/**
 * class which creates a queue of the order of the nodes, for level order traversal, much the same as a linked list
 * 
 * @param <dataType> the type of data which will be stored in the this node.
 */
public class BTQueue<dataType>
{   
   BTQueueNode<dataType> head;
   BTQueueNode<dataType> tail;
      
   /**
    * no argument contructor to create an empty BTQueue
    */
   public BTQueue ()
   {
      head = null;
      tail = null;
   }
   /**
    * This method will fetch the next node of the Queue
    * 
    * @return a node of which is the queue head ie. next
    */
   public BinaryTreeNode<dataType> getNext ()
   {
      if (head == null)
         return null;
      BTQueueNode<dataType> qnode = head;
      head = head.next;
      if ( head == null )
         tail = null;
      return qnode.node;
   }
   /**
    * Adds a Queue node to the Queue
    * if the Queue is empty then the tail and head will both be set as the @param node 
    * 
    * @param node the node that will be added to the queue
    */
   
   public void enQueue ( BinaryTreeNode<dataType> node )
   {
      if (tail == null)
      {   
         tail = new BTQueueNode<dataType> (node, null);
         head = tail;
      }   
      else
      {
         tail.next = new BTQueueNode<dataType> (node, null);
         tail = tail.next;
      }   
   }   
}
