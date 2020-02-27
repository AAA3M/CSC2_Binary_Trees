import java.io.FileNotFoundException;
import java.io.IOException;

public class LSBSTApp{
    public static void main(String args[])throws IOException, FileNotFoundException
    {


        if (args.length == 4){
            BTree x  = new BTree("/home/alaric/Documents/CSC2/Ass1/CSC2_Binary_Trees/" + args[3]);

             x.printAreas(args[0], args[1], args[2]);

        }

        if (args.length ==1){
            BTree x  = new BTree("/home/alaric/Documents/CSC2/Ass1/CSC2_Binary_Trees/" + args[0]);

            x.printAllAreas();
        }
    }
}