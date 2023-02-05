# TwitchSumupAllStats

### How to run app: 
`java -jar TwitchSumupAllStats.jar`

### API RESPONSE:

-> GET RESPONSE FROM XAYO.PL  
[server]:[port]/Stats?username=[twitch username]

-> GET RESPONSE FROM XAYO.PL  
[server]:[port]/Compare?txt1=[first name of file]&txt2=[second name of file]

-> AUTOSTATS EVERY DAY AT 1am  
[server]:[port]/AutoStats

-> CURRENT COUNT ALL RECORDS FROM XAYO.PL  
[server]:[port]/Countall/online?username=[twitch username] 

-> COUNT ALL RECORDS FROM TXT  
[server]:[port]/Countall/offline?nameTxt=[name of file]

### Temporary hosted (examples):  
-> Stats  
http://srv14.mikr.us:44445/Stats?username=xmichulol

-> Compare two dates  
http://srv14.mikr.us:44445/Compare?txt1=05-02-2023_xmichulol.txt&txt2=01-02-2023_xmichulol.txt

-> Sumup all records  
-Online -> http://srv14.mikr.us:44445/Countall/online?username=xmichulol  
-Offline -> http://srv14.mikr.us:44445/Countall/offline?nameTxt=02-02-2023_xmichulol.txt
