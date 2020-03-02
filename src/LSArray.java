import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;


/**
 * An LSArray class which will read and store data in the from of a String from a text File in the form of an object LSArray.
 * @author Alaric McGregor
 */

public class LSArray{
    private int fileLength;
    private String[] data;
    private File file;
    public int DiscreteCount;

    /**
     *  Constructor for the LSArray, a helper class which will take make an Array filled with Strings from a text file
     * @param FileName This is a String which will take a file name ie "Data.txt" and load data from this file into and array.
     * @throws IOException throws an exception if the file is not found
     */
    
    public LSArray(String FileName) throws IOException {
        this.file = new File(FileName);
        this.fileLength = fileLen(); 

        this.data = new String[fileLength];


        Scanner sc = new Scanner(file);

        for (int i = 0; i<fileLength;i++){
            this.data[i] = sc.nextLine();
        }

        sc.close();



    }

    /**
     *  Finds the Length of the Text file we are working with, used in the constructor for LSArray.
     *
     * @return This returns an int which is the size of the text file.
     * @throws IOException throws an exception if no file is found
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
     * This method prints specific areas of a given LSArray based on the parameters given which form a unique key to search for the item in the LSArray
     * It will also print out how many operations it took to find and to insert into the array.
     * 
     * @param stage This is the Stage of Load shedding, and will form part of the key
     * @param day This is the day in which Load shedding occurs, and will form part of the key
     * @param startTime This is the time in which load shedding occurs, and will form part of the key
     */
    public  void printAreas(String stage, String day, String startTime){

        String check = new String (stage + "_"+day+"_"+startTime);
        String found = new String ("No Zone found for: ");
        int len = 0;

        DiscreteCount = 0;
        if (stage != "" && day!="" &&startTime!=""){
        len = this.fileLength;
        for (int i=0;i<len;i++){
            DiscreteCount ++; //instrumentation
            if (this.data[i].contains(check)){



                found = "Zone(s) found:";
                check = this.data[i];
                break;
            }
        }
        System.out.println(found);
        System.out.println(check);
        System.out.println("Number of comparisons to insert:");
        System.out.println("0");
        System.out.println("Number of comparisons to find:");
        String Disc = "";
        Disc = Disc + DiscreteCount;
        System.out.print(Disc);
    }
    else {System.out.println("Invalid Arguments");}

    }
    /**
     * prints all the areas in the LSArray
     */

    public  void printAllAreas(){
        int len = this.fileLength ;

        for (int i =0;i<len;i++){
            System.out.println(this.data[i]);
        }
    }
    /**
     *  get length of file
     * @return returns the length of the file
     */

    public int getFileLength(){
        return this.fileLength;
    }
    /**
     * gets all the data from the LSArray
     * @return Array of Strings containing all data
     */

    public String[] getData(){
        return this.data;
    }

}