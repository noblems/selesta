import java.io.*;

import com.opencsv.CSVWriter;
public class CSV {
	public static void main(String[] args){
	File file = new File("./my.csv");
    try {
        // create FileWriter object with file as parameter
        FileWriter outputfile = new FileWriter(file);
        CSVWriter writer = new CSVWriter(outputfile);
        int i;
        String[] header = { "Sl No", "Test case", "Status", "comments" };
        writer.writeNext(header);
        for(i=0;i<10;i++){
        	String[] data1 = { Integer.toString(i) , "test", "testnamae" ,"fail"};
        	writer.writeNext(data1);
        }
        
 
        // closing writer connection
        writer.close();
        System.out.print("done");
    }
    catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
}
