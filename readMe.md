![plot](./enviroment/images/bet-workshop.png)

-----

## UI

URL: http://localhost/

-----
## Bet Service

### Place a Bet

Post: http://localhost:8181/api/v1/bet


### Retrieve Bets

Get: http://localhost:8181/api/v1/bet

-----

## Database Credentials

url:localhost

port:3312

Schema: bet

username: root

password: bet

![plot](./enviroment/images/database_connection_info.png)

-----

## Spin up containers

**On root folder execute the following**

```
docker-compose -f docker-compose.yml up -d
```
-----


## Debug Ports

Bet Service: 8001

-----