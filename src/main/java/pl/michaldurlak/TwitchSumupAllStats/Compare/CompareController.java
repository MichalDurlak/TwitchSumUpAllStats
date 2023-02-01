package pl.michaldurlak.TwitchSumupAllStats.Compare;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = "application/json")
public class CompareController {

    @Autowired
    CompareService compareService;

    @GetMapping("/compare")
    public String getCompareRecords(String txt1, String txt2){
        return compareService.getCompare(txt1,txt2);
    }

}
