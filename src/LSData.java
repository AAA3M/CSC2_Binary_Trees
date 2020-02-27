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
        char space = ' ';
        int linelength = FileLine.length();

        for (int i =0; i<linelength; i++){
            if (FileLine.charAt(i) == space){
                this.Skey = FileLine.substring(0, i);
                this.zones = FileLine.substring(i+1, linelength);
                break;
            }
            
        }
        String temp = "";
        for (int i = 0; i < Skey.length(); i++){
            if (Skey.charAt(i) != '_'){
                temp = temp + Skey.charAt(i);
            }
        }
        this.key = Integer.parseInt(temp);
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

    // methods to prints all areas and print areas

    

    public void printAllAreas(File file){

    }

    public void printAreas(File file){

    }
}