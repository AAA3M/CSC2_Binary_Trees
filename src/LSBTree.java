import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

/**
 * Creates an object which uses the BTree class to fill a BTree from a given file which can then use the printAreas method to find an area in the
 * Load shedding data. This will also display the Search and insert operation counters.
 * 
 * @author Alaric McGregor
 */

public class LSBTree{

    private File file;
    private int fileLength;
    private BTree<String, String> st;
    /**
     * Creats an LSBTree object which takes data from a text file and loads it into a BTree
     * 
     * @param FileName This is the name of the file from which the data for the constructor will be loaded into
     * @throws IOException Throws an exception for a file not found and buffer reader exception
     */

    public LSBTree(String FileName) throws IOException{

        this.file = new File(FileName);
        this.fileLength = fileLen(); 
        Scanner sc = new Scanner(file);
        this.st = new BTree<String, String> ();
        String[] temp;

        for (int i=0; i< fileLength; i ++){
            temp = sc.nextLine().split(" ", 2);
            st.put(temp[0], temp[1]);
        }
        sc.close();

    }
    /**
     * Finds the file length of the file which the LSBTree object is using
     *
     * @return returns an int the size of the file length
     * @throws IOException throws exception if the bufferedreader doesn't work or the file isn't found.
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
     * Method to print the areas for a BTree given a specifiic key. The method will display the Zones found
     * and it will display the Insert Count and Search Count for the BTree.
     * 
     * @param stage This is the Stage of Load shedding, and will form part of the key
     * @param day This is the day of Load shedding, and will form part of the key
     * @param startTime This is the starting time of Load shedding, and will form part of the key
     */

    public void printAreas(String stage, String day, String startTime){
        String check = new String (stage + "_"+day+"_"+startTime);
        System.out.println(check + ": " + st.get(check));
        System.out.println("Insert counter:");
        System.out.println(st.DiscreteCounterI);
        System.out.println("Search counter:");
        System.out.println(st.DiscreteCounterS);
    }
    
}