package pl.michaldurlak.TwitchSumupAllStats.Files;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Service
public class ReadFileArchive {


    public String readSpecificFileFromArchive(String fileName) {
        String dataResponse = null;
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                dataResponse = data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            dataResponse = "error";
        }
        return dataResponse;
    }
}
