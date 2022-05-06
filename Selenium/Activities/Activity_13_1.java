package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class Activity_13_1 {
    public static void main(String[] args) throws IOException, CsvException {
        //Load CSV file
        CSVReader reader = new CSVReader(new FileReader("src/test/java/sample.csv"));

        //Load content into list
        List<String[]> list = reader.readAll();
        System.out.println("Total number of rows are: " + list.size());

        //Create Iterator reference
        Iterator<String[]> itr = list.iterator();

        //Iterate all values
        while(itr.hasNext()) {
            String[] str = itr.next();

            System.out.print("Values are: ");
            for(int i=0;i<str.length;i++) {
                System.out.print(" " + str[i]);
            }
            System.out.println(" ");
        }

        reader.close();
    }
}