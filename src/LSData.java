import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class LSData implements Comparable<LSData>{  
    private String fileLine;
    private int key;
    private String zones;
    private String Skey;

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

    public String getZones(){
        return this.zones;
    }

    public String keyString(){
        return this.Skey;
    }

    public int getKey(){
        return this.key;
    }
}