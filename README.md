# SpringBoot/JSP

SpringBoot &amp; JSP with embedded Tomcat/Jasper container in Docker

Run 
> mvn clean install

> docker run -d --publish 8089:8089 com.webgenerals/springboot-jsp-service:1.0-SNAPSHOT

Open 
- http://localhost:8089/book/viewBooks
- http://localhost:8089/book/addBook