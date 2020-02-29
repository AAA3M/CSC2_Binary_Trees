// Hussein's Binary Search Tree
// 27 March 2017
// Hussein Suleman

public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   public int DiscreteCounter = 0;
   public int DiscreteCounterInsert = 0;
   public void insert ( dataType d )
   {
      if (root == null)
         root = new BinaryTreeNode<dataType> (d, null, null);
      else
         insert (d, root);
   }
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
   
   public BinaryTreeNode<dataType> find ( dataType d )
   {
      if (root == null) //Don't incriment as we are checking for null 
         return null;
      else
         return find (d, root);
   }
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
   
   public void delete ( dataType d )
   {
      root = delete (d, root);
   }   
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
   
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }

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
