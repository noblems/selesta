

import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.opencsv.CSVWriter;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class Second {


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    	System.setProperty("webdriver.gecko.driver","/home/SPERIDIAN.DC/noble.saji/selesta/geckodriver");
		WebDriver driver = new FirefoxDriver();
		File file = new File("./myresults.csv");
		 String baseUrl = "https://qa-ee.benefitalign.com/EE";
	        String expectedTitle = "Sign In";
	        String actualTitle = "";
	        String status="";

	       try{
	    	   FileWriter outputfile = new FileWriter(file);
	           CSVWriter writer = new CSVWriter(outputfile);
	           int i=1;
	           String[] header = { "Sl No", "Test case", "Status", "comments" };
	           writer.writeNext(header);
	        driver.get(baseUrl);

	        
	        actualTitle = driver.getTitle();

	        /*
	         * compare the actual title of the page with the expected one and print
	         * the result as "Passed" or "Failed"
	         */
	        if (actualTitle.contentEquals(expectedTitle)){
	            status= "pass";
	        } else {
	        	status="fail";
	        }
	       
	        //close Fire fox
	        driver.close();
	        String[] data1 = { Integer.toString(i) , "title", status ,actualTitle};
        	writer.writeNext(data1);
        	writer.close();
            System.out.print("done");
	       }catch(Exception e){
	    	   
	       }
    }

}


