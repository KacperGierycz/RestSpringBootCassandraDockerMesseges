# RestSpringBootCassandraDockerMesseges

Readme

Welcome to the Message Rest Cassandra Docker ... application enjoy.

Mine docker expertise is still in development then please stick to how to run manual.

The app is made with docker compose, cassandra and Spring app are on separate images and containers but are present like one on docker desktop container.

How to run:

    Pull the images of Cassandra and Spring app
    Start images from docker desktop
    Start the single container cassandra (under it are two) which will auto-start cassandra container and Spring app
   
Below are links to DockerHub cassandra image, java image, and whole repo of both. I'm not sure that others can browse the main repo without login to DockerHub because of this there is a Readmy of this repo below links. I had a great time with this development wish you would too.

linki:
cassandra
https://hub.docker.com/layers/169162285/kacpergierycz/messages-spring-cassandra-docker/cassandra/images/sha256-5daca55c5fdcf8b55c7d623e2346628de42609e2be7a1422cd9e3bedcb133222?context=repo

java
https://hub.docker.com/layers/169162593/kacpergierycz/messages-spring-cassandra-docker/java/images/sha256-8b06bab99c8156921c3eb742f9ed48057504aebffab5a766590ba4c2cd766421?context=repo

together
https://hub.docker.com/repository/docker/kacpergierycz/messages-spring-cassandra-docker

The Spring is listening on port localhost:8080/

POST add a single one with a response of this one
<br>
http://localhost:8080/api/message
{
   
  
    "email": "jan.kowalski@example.com",
    "title": "Interview",
    "content": "simple text",
    "magic_number": "101
}

GET response with a list no paggination jet (need upgrade in Spring Boot verion and Cassandra configuration)
<br>
http://localhost:8080/api/messages

POST deleteing the magic_number == 101 from db response with list of deleted records
<br>
http://localhost:8080/api/send

GET to get a messages of a given email and delete them from db
<br>
http://localhost:8080/api/messages/anna.zajkowska@example.com

All REST points from the task list are available the db is populated with 2 messages. After 5 min messages are deleted with the scheduler sometimes it's enabling after 10 min from startup. The CRUD is available thanks to extend RestRepository . I had to work on data with only basic commands course of my tutorial was a quick one;). The one part that I skip was pagination because of the same reason. REST is working like a charm. The best part of the development was the Message Entity this one had to change its name to Content due to unknown reasons and REST came to live. An experience like a whole was greate.

Cheers, Kacper
