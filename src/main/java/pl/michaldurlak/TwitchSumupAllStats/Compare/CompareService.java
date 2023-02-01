package pl.michaldurlak.TwitchSumupAllStats.Compare;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michaldurlak.TwitchSumupAllStats.App.AppService;
import pl.michaldurlak.TwitchSumupAllStats.Files.ReadFileArchive;

@Service
public class CompareService {

    @Autowired
    ReadFileArchive readFileArchive;

    @Autowired
    AppService appService;

    public String getCompare(String txt1, String txt2){
        JSONArray record1 = new JSONObject(readFileArchive.readSpecificFileFromArchive(txt1)).getJSONArray("xayo.pl");
        JSONArray record2 = new JSONObject(readFileArchive.readSpecificFileFromArchive(txt2)).getJSONArray("xayo.pl");

        JSONObject jsonObjectResponse = new JSONObject();

        for(int i=0;i<record1.length();i++){
            String streamerFromRecord1 = record1.getJSONObject(i).getString("streamer");
            int countFromRecord1 = record1.getJSONObject(i).getInt("count");


            for(int j=0;j<record2.length();j++){
                String streamerFromRecord2Temp = record2.getJSONObject(j).getString("streamer");
                int countFromRecord2Temp = record2.getJSONObject(j).getInt("count");

                if(streamerFromRecord2Temp.equals(streamerFromRecord1)){
                    if(countFromRecord2Temp == countFromRecord1){

                    } else {
                        //Difference count
                        int countRecord1MinusRecord2 = countFromRecord1-countFromRecord2Temp;
                        String parsedCountRecord1MinusRecord2 = appService.parseCountResponseFromXayo(countRecord1MinusRecord2);

                        JSONObject jsonObjectDifferenceCountTemp = new JSONObject();
                        jsonObjectDifferenceCountTemp.put("streamer",streamerFromRecord1).put("parsedCount",parsedCountRecord1MinusRecord2).put("count",countRecord1MinusRecord2);

                        jsonObjectResponse.append("Compare/"+txt1+"/"+txt2,jsonObjectDifferenceCountTemp);
                    }

                }
            }
        }
        return jsonObjectResponse.toString();
    }
}
