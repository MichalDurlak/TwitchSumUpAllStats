package pl.michaldurlak.TwitchSumupAllStats.App;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.michaldurlak.TwitchSumupAllStats.Files.CreateFileArchive;
import pl.michaldurlak.TwitchSumupAllStats.Files.ReadFileArchive;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping(produces = "application/json")
@EnableScheduling
public class AppController {

    @Autowired
    AppService appService;

    @Autowired
    CreateFileArchive createFileArchive;

    @Autowired
    ReadFileArchive readFileArchive;

    @GetMapping("/WriteToArchive")
    @Scheduled(cron = "0 0 1 * * *")
    public String getResults() throws FileNotFoundException, UnsupportedEncodingException {
        //Request to xayo.pl login -> xmichulol
        String request_xmichulol = appService.getResponseFromXayo("xmichulol");
        JSONObject jsonObject = appService.parseResponseFromXayo(request_xmichulol);
        createFileArchive.createTextFile(jsonObject.toString(), "xmichulol");
        return jsonObject.toString();
    }

    @GetMapping("/ReadFromArchive")
    public String getOdczytPliku(String data){
        return readFileArchive.readSpecificFileFromArchive("Archive/"+data);
    }

}
