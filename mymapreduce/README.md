1) Install docker in the machine (This is tried for mac)
$ docker version

2) Pull Cloudera quickstart docker

$ docker pull cloudera/quickstart:latest

3) Check images
$ docker images

4) Run quickstart docker

$ docker run --hostname=quickstart.cloudera --privileged=true -t -i -p 8888:8888 -p 10000:10000 -p 10020:10020 -p 11000:11000 -p 18080:18080 -p 18081:18081 -p 18088:18088 -p 19888:19888 -p 21000:21000 -p 21050:21050 -p 2181:2181 -p 25000:25000 -p 25010:25010 -p 25020:25020 -p 50010:50010 -p 50030:50030 -p 50060:50060 -p 50070:50070 -p 50075:50075 -p 50090:50090 -p 60000:60000 -p 60010:60010 -p 60020:60020 -p 60030:60030 -p 7180:7180 -p 7183:7183 -p 7187:7187 -p 80:80 -p 8020:8020 -p 8032:8032 -p 802:8042 -p 8088:8088 -p 8983:8983 -p 9083:9083 4239cd2958c6 /usr/bin/docker-quickstart

5) Check the container
$ docker ps -a

6)  Inside container start the cloudera manager

$ sudo /home/cloudera/cloudera-manager --express

7) Go to: http://localhost:7180/ and start hdfs, hive , yarn etc


To copy local files to docker

Get the container id of clludera quickstart from docker ( use docker ps -a)
eg: d024000f331f

$ docker cp vinod.txt d024000f331f:/vinod.txt

Copy from docker to host $ docker cp 72ca2488b353:/foo.txt foo.txt


8) 
Build project and create jar and copy jar to the docker container  (Map reduce project)

docker cp mymapreduce-0.0.1-SNAPSHOT.jar d024000f331f:/mymapreduce-0.0.1-SNAPSHOT.jar

9) Once copied run the mapreduce job

hadoop jar mymapreduce-0.0.1-SNAPSHOT.jar com.vinod.Driver vinod/vinod.txt output

10) Once it ran use below command to check output

hdfs dfs -cat output/part*