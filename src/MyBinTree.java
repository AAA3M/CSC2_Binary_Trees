import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class MyBinTree{
    private File file;
    private int fileLength;
    private BinarySearchTree<LSData> bt;

    public MyBinTree(String FileName) throws IOException{

        this.file = new File(FileName);
        this.fileLength = fileLen(FileName); 
        Scanner sc = new Scanner(file);
        this.bt = new BinarySearchTree<LSData> ();
        


        for (int i=0; i< fileLength; i ++){

            bt.insert(new LSData(sc.nextLine()));
        }
        sc.close();
    }


    public int fileLen(String FileName) throws IOException{
        int fileLeng = 0;

        BufferedReader br = new BufferedReader(new FileReader(this.file));
        while (br.readLine() != null) {
            fileLeng ++;
        }
        br.close();
        return fileLeng;
    }

    public void printAllAreas(){
        bt.inOrder();

    }

    public void printAreas(String stage, String day, String startTime){
        String check = new String (stage + "_"+day+"_"+startTime + " NA");


        BinaryTreeNode<LSData> x = (bt.find(new LSData(check)));
        if (x==null){
            System.out.println("No zones found");
            System.out.println();
            System.out.println("Number of comparisons to insert:"+ bt.DiscreteCounterInsert);
            System.out.println("Number of comparisons to find:" + bt.DiscreteCounter);
        }
        if (x != null){
        System.out.println((x.data).toString());
        System.out.println("Number of comparisons to insert:");
        System.out.println(bt.DiscreteCounterInsert);
        System.out.println("Number of comparisons to find:");
        System.out.println(bt.DiscreteCounter);
        }
    }


}