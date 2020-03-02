import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * App which excecutes the printAreas and printAllAreas methods of the LSData object using a Binary Search Tree.
 * It follows user arguments to determine the textfile and the key
 * 
 * @author Alaric McGregor
 */
public class LSBSTApp{
    public static void main(String args[])throws IOException, FileNotFoundException
    {
        String path = "/home/alaric/Documents/CSC2/Ass1/CSC2_Binary_Trees/DataFiles/";

        if (args.length == 4){
            MyBinTree x  = new MyBinTree(path + args[3]);

             x.printAreas(args[0], args[1], args[2]);

        }

        if (args.length ==1){
            MyBinTree x  = new MyBinTree(path + args[0]);

            x.printAllAreas();
        }
    }
}