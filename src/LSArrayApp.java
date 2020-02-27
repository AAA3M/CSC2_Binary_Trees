import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class LSArrayApp{


    public static void main(String args[]) throws IOException, FileNotFoundException
    {
             
        if (args.length == 1){
            LSArray arr = new LSArray("/home/alaric/Documents/CSC2/Ass1/CSC2_Binary_Trees/" + args[0]);
            arr.printAllAreas();
        }
        if (args.length == 4){
            LSArray arr = new LSArray("/home/alaric/Documents/CSC2/Ass1/CSC2_Binary_Trees/" + args[3]);
            arr.printAreas(args[0], args[1], args[2]);
        }

    }


}