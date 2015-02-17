package functional;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.testng.reporters.Files.readFile;

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
        writer.println("Ahalay mahalay 12.25");
        writer.close();

    }
    @Test
    public void someTests() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("Test.txt"));
        String text = "";
        String pattern = ".*\\d+(\\.\\d+).*";
        try {
            text = br.readLine();
        } finally {
            br.close();
        }
        Assert.assertTrue(text.matches(pattern));
    }
    @AfterTest
    public boolean deleteFile(){
        File file = new File("Test.txt");
        return file.delete();
    }

}
