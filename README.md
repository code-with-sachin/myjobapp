This is a Job Application 

This contains below features:

1) Posting New Jobs, Updating Job, Deleting job, Getting Job/s.
2) Posting New Company, Updating Company, Deleting company, Getting company/s.
3) Posting New Review, Updating review, Deleting review, Getting review.


I will share Postman Documenation link soon.


DB used in Postgres SQL and in memory Database H2 for testing our REST APIs

We have Docker integration as well into our application.

Command: ./mvnw spring-boot:build-image "-Dspring-boot.build-image.imageName=<IMAGE-NAME>"

./mvnw spring-boot:build-image "-Dspring-boot.build-image.imageName={docker-username}/jobappimage"

Note: Before running above command in Terminal/CLI make sure Docker Desktop is running on System. Also we should have maven plugin dependency in POM.xml or else Docker file with instructions.
