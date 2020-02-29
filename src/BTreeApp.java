import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class BTreeApp{
    public static void main(String[] args) throws IOException, FileNotFoundException{
        String path = "/home/alaric/Documents/CSC2/Ass1/CSC2_Binary_Trees/DataFiles/";
        if (args.length==4){
            LSBTree x  = new LSBTree(path + args[3]);

            x.printAreas(args[0], args[1], args[2]);

        }
        
    }
}