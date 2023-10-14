### Build Image

docker build -t bet-app-mysql .

### Run Image

docker run -d -p 3311:3306 --name bet-app-mysql bet-app-mysql

### Find version of mysql

https://stackoverflow.com/questions/57806118/how-to-check-mysql-version-inside-mysql-docker-container

### Credentials

root
supersecret

### Get Mysql Version

docker inspect mysql-container | grep MYSQL_MAJOR

### ERROR public key retrieval is not allowed

![](C:\Users\mverros\Desktop\archive\projects\forStudy\readMe\images\mysql\public_key_retrieval_is_not_allowed.JPG "Point to point JMS Messaging")

docker run -d -p 8080:8080 --name admin-container admin
