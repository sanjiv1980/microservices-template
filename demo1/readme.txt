docker run -e MYSQL_ROOT_PASSWORD=password -p 3306:3306  mysql
docker exec -it be6382ff4b27 bash

# build jar
gradlew build

#Go to build/libs folder to pic jar and run from below command
java -Dspring.profiles.active=prod -jar demo1-0.0.1-SNAPSHOT.jar

# got to logback.xml directory and run below command
java -Dspring.profiles.active=prod -jar build/libs/demo1-0.0.1-SNAPSHOT.jar