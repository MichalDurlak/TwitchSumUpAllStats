package pl.michaldurlak.TwitchSumupAllStats.App;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AppService {

    private static String URL = "https://xayo.pl/api/mostWatched/";

    public String getResponseFromXayo(String username){
        RestTemplate restTemplate = new RestTemplate();
        String responseFromXayoAsString = restTemplate.getForObject(URL+username,String.class);
        return responseFromXayoAsString;
    }

    public JSONObject parseResponseFromXayo(String originalResponseFromXayo){

        JSONArray jsonArray = new JSONArray(originalResponseFromXayo);
        JSONObject jsonObjectResponse = new JSONObject();
        for (int i=0 ; i<jsonArray.length() ; i++){

            JSONObject jsonObjectTemp;
            jsonObjectTemp = jsonArray.getJSONObject(i);

            System.out.println("STREAMER -> " +jsonObjectTemp.getString("streamer") + " Ile czasu -> "+parseCountResponseFromXayo(jsonObjectTemp.getInt("count")));
            jsonObjectResponse.put(jsonObjectTemp.getString("streamer"),parseCountResponseFromXayo(jsonObjectTemp.getInt("count")));
        }

        return jsonObjectResponse;
    }

    public String parseCountResponseFromXayo(int countFromXayo){
        int getMinutes = countFromXayo*5;
        String weeks = getMinutes/7/24/60 +"tygodni";
        String days = getMinutes/24/60%7 +"dni";
        String hours = getMinutes/60%24 +"godzin";
        String minutes = getMinutes%60 +"minut";
        return weeks + ", " +days+ ", " +hours+ ", " +minutes;
//        return getMinutes/7/24/60 + ":" + getMinutes/24/60%7 + ":" + getMinutes/60%24 + ':' + getMinutes%60;
    }
}
