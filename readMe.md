![plot](./enviroment/images/bet-workshop.png)


Admin Panel
url: http://localhost/

-----

Place A Bet Service
url: http://localhost:8181/api/v1/bet
Post

-----

Retrieve Bet Service
url: http://localhost:8181/api/v1/bet
Get

-----

Antifraud Service
url: http://localhost:8182/api/v1/antifraud/check
Post

-----

Database Credentials
url:localhost
port:3312
Schema: bet
username: root
password: bet

-----

Spin up app

docker-compose -f docker-compose.yml up -d

-----

