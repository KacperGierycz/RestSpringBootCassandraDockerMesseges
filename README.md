# RestSpringBootCassandraDockerMesseges

Readme

Welcome to the Message Rest Cassandra Docker ... application enjoy.

Mine docker expertise is still in development then please stick to how to run manual.

The app is made with docker compose, cassandra and Spring app are on separate images and containers but are present like one on docker desktop container.

How to run:

    Pull the images of Cassandra and Spring app
    Start images from docker desktop
    Start the single container cassandra (under it are two) which will auto-start cassandra container and Spring app

The Spring is listening on port localhost:8080/

POST add a single one with a response of this one
http://localhost:8080/api/message
{
   
  
    "email": "jan.kowalski@example.com",
    "title": "Interview",
    "content": "simple text",
    "magic_number": "101
}

GET response with a list no paggination jet (need upgrade in Spring Boot verion and Cassandra configuration)
http://localhost:8080/api/messages

POST deleteing the magic_number == 101 from db response with list of deleted records
http://localhost:8080/api/send

GET to get a messages of a given email and delete them from db
http://localhost:8080/api/messages/anna.zajkowska@example.com

All REST points from the task list are available the db is populated with 2 messages. After 5 min messages are deleted with the scheduler sometimes it's enabling after 10 min from startup. The CRUD is available thanks to extend RestRepository . I had to work on data with only basic commands course of my tutorial was a quick one;). The one part that I skip was pagination because of the same reason. REST is working like a charm. The best part of the development was the Message Entity this one had to change its name to Content due to unknown reasons and REST came to live. An experience like a whole was greate.

Cheers, Kacper
