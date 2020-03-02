// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman
/**
 * Binary Tree class (BT). Data Structure that takes nodes as imputs which are not comparable
 * 
 * @param <dataType> The Datatype that fills the Binary Tree
 */
public class BinaryTree<dataType>
{
   BinaryTreeNode<dataType> root;
   
   /**
    * no argument constructor for BT, sets the root of the Tree to null
    */
   public BinaryTree ()
   {
      root = null;
   }
   /**
    * no argument method calls the getHeight method on the root node of this.BT
    * 
    * @return int which is the height of the BT
    */
   public int getHeight ()
   {
      return getHeight (root);
   }   
   /**
    * Method to get the height of the BT. (number of levels in the BT) by recursivly finding height of child nodes and returning the maximum branch.
    * 
    * @param node the current node being used
    * @return int which is the height of the BT
    */
   public int getHeight ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   /**
    * no argument method which calls the getHeight method on the root node of this.BT
    * 
    * @return int which is the height of the BT
    */
   
   public int getSize ()
   {
      return getSize (root);
   }   
   /**
    * Gets the total number of nodes in the BT, by recursivly calling the getSize method and incrimenting for every node traveled to
    * 
    * @param node the current node being used in the getSize method
    * @return int which is the total number of nodes in the BT
    */
   public int getSize ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   /**
    * prints out the data of the current node
    * 
    * @param node the node being used.
    */
   public void visit ( BinaryTreeNode<dataType> node )
   {
      System.out.println (node.data);
   }
   /**
    * no argument method to call the preOrder method on the root of this.BT
    */
   
   public void preOrder ()
   {
      preOrder (root);
   }
   /**
    * prints out the preOrder traversal of the Binary Tree by recursivly calling itself.
    * Visit the node before its children.
    * 
    * @param node current node being used for calculations.
    */
   public void preOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }   
   }
   /**
    * no argument method to call the postOrder method on the root of this.BT
    */
   public void postOrder ()
   {
      postOrder (root);
   }
   /**
    * prints out the postOrder traversal of the Binary Tree by recursivly calling itself.
    * Visit the node after its children.
    * 
    * @param node current node being used for calculations.
    */
   public void postOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }   
   }
   /**
    * no argument method to call the inOrder method on the root of this.BT
    */
   public void inOrder ()
   {
      inOrder (root);
   }
   /**
    * prints out the inOrder traversal of the Binary Tree by recursivly calling itself.
    * Visit the node after left child but before right child
    * 
    * @param node current node being used for calculations.
    */
   public void inOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }
/**
 * method to print out the levelOrder traversal of this.BT
 * uses the BTQueue class to determine the level in which a node is positioned.
 * Add the root node to a queue
 * while the queue is non empty: pop a node and visit it and add its children
 */
   public void levelOrder ()
   {
      if (root == null)
         return;
      BTQueue<dataType> q = new BTQueue<dataType> ();
      q.enQueue (root);
      BinaryTreeNode<dataType> node;
      while ((node = q.getNext ()) != null)
      {
         visit (node);
         if (node.getLeft () != null)
            q.enQueue (node.getLeft ());
         if (node.getRight () != null)
            q.enQueue (node.getRight ());
      }
   }
}
