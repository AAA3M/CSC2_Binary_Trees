import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
/**
 * LSData is an object which recieves a String and creates a key which will implement the comparable interface.
 * 
 * @author Alaric McGregor
 */

public class LSData implements Comparable<LSData>{  
    private String fileLine;
    private int key;
    private String zones;
    private String Skey;
    /**
     * Constructor for LSData Object, this will split the String into a comparable key
     * @param FileLine This is a String which is then used to generate a key.
     */

    public LSData(String FileLine) {
        this.fileLine = FileLine;

        String[] arrOfStr = fileLine.split(" ", 2);
        this.Skey= arrOfStr[0];
        this.zones = arrOfStr[1];
        arrOfStr = Skey.split("_", 3);
        this.key = Integer.parseInt(arrOfStr[0]+arrOfStr[1]+arrOfStr[2]);
    }



    public int compareTo(LSData other){
        if (this.key == other.key){
            return 0;
        }
        if (this.key < other.key){
            return -1;
        }
        else{
            return 1;
        }

    }


    public String toString(){
        return this.fileLine;
    }

    /**
     * returns the zones from load shedding data ie, the areas which will be affected from the input string
     * @return part of the initial string, doesn't include the key
     */

    public String getZones(){
        return this.zones;
    }
    /**
     *  Returns the key in string form
     * @return String version of key.
     */

    public String keyString(){
        return this.Skey;
    }
    /**
     * Returns the key in integer form
     * @return int version of key.
     */

    public int getKey(){
        return this.key;
    }
}