# kafka-svc
#Steps to run kafka server and zookeeper locally on windows

1 . You need to download kafka server zip file from below website
    https://kafka.apache.org/downloads

2. Unzip the folder and then move into kafka/cnfig folder 

3. Open server.properties file and change the value of log.dirs for eg:- log.dirs=c:/kafka/data-logs

4. Same way go to zookeeper.properties file and change the value of dataDir for eg:- dataDir=c:/kafka/data

5. for step 3 and 4 you can create folders for logs and data within kafka folder, this is basically to log the data and logs.

6. Now its time to run your zookeeper and kafka server.

7. command to run zookeeper server and kafka server (First you need to be within bin folder path) 
   zookeeper-server-start.bat ../../config/zookeeper.properties
   kafka-server-start.bat ../../config/server.properties
  
  (Assuming you have the same folder structure as mentioned above

8. Now its time to create a topic
   command to create a topic:-
   Note :- You need to have separate command prompts opened for each command mentioned above.
   
   kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
   
   I have given topic name as test you can give your name and the port number would be the one mentioned within server.properties file.
   Here i am just creating one broker just to make things simple to understand.
   You can have n replication-factor(broker) and n partitions of each broker for same topic.

9. Now for group id and bootstrap.servers you need to look into the consumer and producer properties file.
   You can change the group name but do not change the port as its been configured that way.

10 .Walla!!! now import the producer and consumer microservices project make the name changes for topic, group and server accordingly and have fun.   
   