import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;


/**
 * App which executes The printAllAreas and printAreas methods from LSArrayApp depending on arguments from the user.
 * @author Alaric McGregor
 */
public class LSArrayApp{
    /**
     * main method which will run methods from the LSArray class depending on arguments from the user.
     * 
     * @param args list of String arguments including a name of the file.
     * @throws FileNotFoundException throws an exception if there is no file.
     */

    public static void main(String args[]) throws IOException, FileNotFoundException
    {
        String path = "/home/alaric/Documents/CSC2/Ass1/CSC2_Binary_Trees/DataFiles/";
             
        if (args.length == 1){
            LSArray arr = new LSArray(path + args[0]);
            arr.printAllAreas();
        }
        if (args.length == 4){
            LSArray arr = new LSArray(path + args[3]);
            arr.printAreas(args[0], args[1], args[2]);
        }

    }


}