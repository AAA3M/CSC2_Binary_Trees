// Hussein's Binary Search Tree
// 27 March 2017
// Hussein Suleman
/**
 * Binary Search Tree (BST) class that uses a binary tree data structure and implements comparable to allow nodes of data to be compared
 * 
 * @author Hussein Suleman
 * @param <dataType> This is the type of data that the BST will accept. This must extend comparible
 */

public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   public int DiscreteCounter = 0;
   public int DiscreteCounterInsert = 0;
   /**
    * Method to insert into the binary tree. This tests to see if the root exists, and will then either create a BST or call the insert method
    * 
    * @param d this is an argument for the object which will be inserted into the tree.
    */
   public void insert ( dataType d )
   {
      if (root == null)
         root = new BinaryTreeNode<dataType> (d, null, null);
      else
         insert (d, root);
   }
   /**
    * Inserts an object into the binary tree by testing if the root node of the current node is less than or greater than the current node
    * 
    * @param d this is an argument for the object which will be inserted into the tree.
    * @param node this is the root node of @param d 
    */
   public void insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      DiscreteCounterInsert ++;
      if (d.compareTo (node.data) <= 0)
      {
         if (node.left == null) 
            node.left = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.left);
      }
      else
      {
         if (node.right == null){

            node.right = new BinaryTreeNode<dataType> (d, null, null);}
         else{
            insert (d, node.right);}
      }
   }
   /**
    * This method searches the BST and returns the BinaryTreeNode. This find method tests to see if the root of the node @param d is null
    * 
    * @param d this is an argument for the object which will be searched for in the tree.
    * @return this method returns the BinaryTreeNode which is being looked for
    */
   public BinaryTreeNode<dataType> find ( dataType d )
   {
      if (root == null) //Don't incriment as we are checking for null 
         return null;
      else
         return find (d, root);
   }
   /**
    * This method searches the BST, it uses the compareTo method to inspect nodes and search through the tree.
    * If the compareTo method returns something less 0 than it will recursivly run the find function on the left Node, and visa versa for something greater than 0
    *
    * @param d this is an argument for the object which will be searched for in the tree.
    * @param node this is the current node which is being comparedTo the argument @param d
    * @return this will return the Binary Tree Node which is equal to the object being searched for.
    */
   public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node )
   {
      DiscreteCounter ++;
      if (d.compareTo (node.data) == 0) {
         
         return node;}
         
      else if (d.compareTo (node.data) < 0){
         DiscreteCounter ++;

         return (node.left == null) ? null : find (d, node.left);}

      else{
         DiscreteCounter++;
         return (node.right == null) ? null : find (d, node.right);}
   }
   
   /**
    * removes a node from the BST
    * 
    * @param d an argument for the node which will be deleted from the BST
    */
   public void delete ( dataType d )
   {
      root = delete (d, root);
   }   
   /**
    * Remvoes a node from the BST by recursivly calling the delete function.
    * This will use the compareTo method to test if the node which will be deleted is the current node
    * 
    * @param d the node which is going to be deleted
    * @param node the current node that is selected in the BST
    * @return returns a Binary Tree Node. This will be the root of the current node, which will remove the current node. or a null value if there is @param node is null
    */
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else if (node.left != null && node.right != null )
      {
         node.data = findMin (node.right).data;
         node.right = removeMin (node.right);
      }
      else
         if (node.left != null)
            node = node.left;
         else
            node = node.right;
      return node;
   }
   
   /**
    * Finds the minimum value of the BST from a node by traversing the left half of the tree from that node.
    * 
    * @param node the starting node in the tree (to find the absolute min one should set this to the root)
    * @return A Binary Tree Node which is the mimimum value from a node @param node
    */
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }
   /**
    * Removes the local minimum node from a starting node in a BST
    * 
    * @param node the starting node in the tree 
    * @return returns a null if @param node is null or it returns the right node of the Root of the left most (minimum) child of @param node
    */

   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return null;
      else if (node.left != null)
      {
         node.left = removeMin (node.left);
         return node;
      }
      else
         return node.right;
   }
   
}
