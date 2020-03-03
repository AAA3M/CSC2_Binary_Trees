import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * App that excecutes the printAreas function on a LSBTree that has been filled with data from a text file of the users choice. 
 * @author
 */
public class BTreeApp{
    /**
     * main method which will run methods from the LSBTree class depending on arguments from the user.
     * 
     * @param args list of String arguments including a name of the file.
     * @throws FileNotFoundException throws an exception if there is no file.
     */
    public static void main(String[] args) throws IOException, FileNotFoundException{
        String path = "/home/alaric/Documents/CSC2/Ass1/CSC2_Binary_Trees/DataFiles/";
        if (args.length==4){
            LSBTree x  = new LSBTree(path + args[3]);

            x.printAreas(args[0], args[1], args[2]);
        }
        
    }
}