package pl.michaldurlak.TwitchSumupAllStats.Files;

import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CreateFileArchive {

//    public void createFolder(){
//        String folderName = getPathAndFolderName();
//        new File(folderName).mkdirs();
//        System.out.println("created");
//    }

    public void createTextFile(String contentOfTextFile,String username) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("Archive/"+getPathAndFolderName()+"_"+username+".txt", "UTF-8");
        writer.println(contentOfTextFile);
        writer.close();
    }

    private String getPathAndFolderName(){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }
}
