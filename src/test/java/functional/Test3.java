package functional;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.testng.reporters.Files.readFile;

/**
 * Created by c2614 on 16.02.2015.
 */
public class Test3 {

    @BeforeTest
    public void createFile(){
        PrintWriter writer = null;
        try{
            writer = new PrintWriter("Test.txt", "UTF-8");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        writer.println("Ahalay mahalay 12.39");
        writer.close();

    }
    @Test
    public void someTests() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("Test.txt"));
        String actual ="";
        String expected = ".*\\d+(\\.\\d+).*";
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            actual = sb.toString();
        } finally {
            br.close();
        }
        Assert.assertTrue(actual.matches(expected));
    }
    @AfterTest
    public boolean deleteFile(){
        File file = new File("Test.txt");
        return file.delete();
    }

}
