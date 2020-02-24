import java.io.File;
import java.util.Scanner;

import java.io.FileNotFoundException;

public class LSArrayApp{

    static int textLen = 2976;

    static String[] data = new String[textLen];

    public static void main(String args[]) throws FileNotFoundException
    {
        
        File file = new File("/home/alaric/Documents/CSC2/Ass1/CSC2_Binary_Trees/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        Scanner sc = new Scanner(file);

        for (int i = 0; i<textLen;i++){
            data[i] = sc.nextLine();
        }
        sc.close();

        if (args.length == 0){
            printAllAreas();
        }
        if (args.length == 3){
            printAreas(args[0], args[1], args[2]);
        }

    }

    public static void printAreas(String stage, String day, String startTime){
        String check = new String (stage + "_"+day+"_"+startTime);
        String found = new String ("No Zone found for: ");

        for (int i=0;i<textLen;i++){
            if (data[i].contains(check)){
                found = "Zone(s) found: \n";
                check = data[i];
                break;
            }
        }
        System.out.println(found);
        System.out.println(check);

    }

    public static void printAllAreas(){
        for (int i =0;i<textLen;i++){
            System.out.println(data[i]);
        }
    }

}