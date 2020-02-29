import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class LSBTree{

    private File file;
    private int fileLength;
    private BTree<String, String> st;

    public LSBTree(String FileName) throws IOException{

        this.file = new File(FileName);
        this.fileLength = fileLen(FileName); 
        Scanner sc = new Scanner(file);
        this.st = new BTree<String, String> ();
        String[] temp;

        for (int i=0; i< fileLength; i ++){
            temp = sc.nextLine().split(" ", 2);
            st.put(temp[0], temp[1]);
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

    public void printAreas(String stage, String day, String startTime){
        String check = new String (stage + "_"+day+"_"+startTime);
        
        System.out.println(check + ": " + st.get(check));
    }
    

}