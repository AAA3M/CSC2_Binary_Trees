// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

/**
 * The class gets a node from a binary tree, and it has the property that the node has a next node(similar to a linked list)
 * 
 * @param <dataType> The data type of the Binary Tree Node
 */
public class BTQueueNode<dataType>
{
   BinaryTreeNode<dataType> node;
   BTQueueNode<dataType> next;
   
   /**
    * The constructor for the BTQueueNode, takes a node from a binary tree and has a next node.
    * 
    * @param n the node from the Binary Tree.
    * @param nxt the node which comes next after the first node @param n
    */
   public BTQueueNode ( BinaryTreeNode<dataType> n, BTQueueNode<dataType> nxt )
   {
      node = n;
      next = nxt;
   }
}
