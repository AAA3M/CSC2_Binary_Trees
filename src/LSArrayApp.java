import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class LSArrayApp{


    public static void main(String args[]) throws IOException, FileNotFoundException
    {
        

        LSArray arr = new LSArray("/home/alaric/Documents/CSC2/Ass1/CSC2_Binary_Trees/DataFile.txt");

        

        if (args.length == 0){
            arr.printAllAreas();
        }
        if (args.length == 3){
            arr.printAreas(args[0], args[1], args[2]);
        }

    }


}