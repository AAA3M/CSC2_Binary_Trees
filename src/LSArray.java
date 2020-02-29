import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class LSArray{
    private int fileLength;
    private String[] data;
    private File file;
    public int DiscreteCount;
    
    public LSArray(String FileName) throws IOException {
        this.file = new File(FileName);
        this.fileLength = fileLen(FileName); 

        this.data = new String[fileLength];


        Scanner sc = new Scanner(file);

        for (int i = 0; i<fileLength;i++){
            this.data[i] = sc.nextLine();
        }

        sc.close();



    }

    public int fileLen(String FileName) throws IOException{
        int fileLeng = 0;
        

        BufferedReader br = new BufferedReader(new FileReader(this.file));
        while (br.readLine() != null) {
            fileLeng ++;
        }
        br.close();
        return fileLeng;
    }

    public  void printAreas(String stage, String day, String startTime){
        String check = new String (stage + "_"+day+"_"+startTime);
        String found = new String ("No Zone found for: ");
        int len = 0;

        DiscreteCount = 0;

        len = this.fileLength;
        for (int i=0;i<len;i++){
            DiscreteCount ++; //instrumentation
            if (this.data[i].contains(check)){



                found = "Zone(s) found:";
                check = this.data[i];
                break;
            }
        }
        System.out.println(found);
        System.out.println(check);
        System.out.println("Number of comparisons to insert:");
        System.out.println("0");
        System.out.println("Number of comparisons to find:");
        String Disc = "";
        Disc = Disc + DiscreteCount;
        System.out.print(Disc);


    }

    public  void printAllAreas(){
        int len = this.fileLength ;

        for (int i =0;i<len;i++){
            System.out.println(this.data[i]);
        }
    }

    public int getFileLength(){
        return this.fileLength;
    }

    public String[] getData(){
        return this.data;
    }

    public File getFile(){
        return this.file;
    }

}