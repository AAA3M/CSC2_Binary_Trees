import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

/**
 * A Class which creates a MyBinTree object which will store data from a text file in a binary search tree.
 * The Tree will load in LSData Objects as arguments and will perform methods to search for Datapoints
 * 
 * @author Alaric McGregor
 */

public class MyBinTree{
    private File file;
    private int fileLength;
    private BinarySearchTree<LSData> bt;

    /**
     * Constructor which will create the MyBinTree object which will load in data from a text file.
     * 
     * @param FileName Name of the File from which data is loaded. eg. "Data.txt"
     * @throws IOException throws an exception if the File is not found.
     */

    public MyBinTree(String FileName) throws IOException{

        this.file = new File(FileName);
        this.fileLength = fileLen(); 
        Scanner sc = new Scanner(file);
        this.bt = new BinarySearchTree<LSData> ();
        


        for (int i=0; i< fileLength; i ++){

            bt.insert(new LSData(sc.nextLine()));
        }
        sc.close();
    }

    /**
     * Method to find the length of the file which the MyBinTree is using
     * 
     * @return an int which is the length of the file 
     * @throws IOException throws an exception if there is no file or the buffered reader doesn't work
     */

    public int fileLen() throws IOException{
        int fileLeng = 0;

        BufferedReader br = new BufferedReader(new FileReader(this.file));
        while (br.readLine() != null) {
            fileLeng ++;
        }
        br.close();
        return fileLeng;
    }

    /**
     * traverses through the Binary search Tree and prints all the Data Nodes in left to right order.
     */

    public void printAllAreas(){
        bt.inOrder();

    }
    /**
     * takes an argument which forms a key and finds an object in the Binary Search Tree with that same key.
     * It will then print out the number of comparisons used to find and insert aswell as if the zone was found 
     * and what zone was found.
     * 
     * @param stage This forms part of the key and is the Stage of the load shedding
     * @param day This forms part of the key and is the day of the load shedding
     * @param startTime This forms part of the key and is the starting time of the load shedding
     */

    public void printAreas(String stage, String day, String startTime){
        String check = new String (stage + "_"+day+"_"+startTime + " NA");


            BinaryTreeNode<LSData> x = (bt.find(new LSData(check)));
            if (x==null){
                System.out.println("No zones found for:");
                System.out.println(stage + "_"+day+"_"+startTime);
                System.out.println();
                System.out.println("Number of comparisons to insert:"+ bt.DiscreteCounterInsert);
                System.out.println("Number of comparisons to find:" + bt.DiscreteCounter);
            }
            if (x != null){
                System.out.println("Zone(s) found for:");
                System.out.println((x.data).toString());
                System.out.println("Number of comparisons to insert:");
                System.out.println(bt.DiscreteCounterInsert);
                System.out.println("Number of comparisons to find:");
                System.out.println(bt.DiscreteCounter);
            }
        
        else
        {
            System.out.println("Invalid Arguments");
        }
    
    
    }  


}