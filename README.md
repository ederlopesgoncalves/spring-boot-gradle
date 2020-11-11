# Spring Boot Project using gradle as a build automation system and providing a distributed cache provider with Redis.
###### [pt] Projeto Spring Boot usando gradle como sistema de automação de compilação e fornecendo um provedor de cache distribuído com Redis.

## Clean Architecture

```
curl -s http://localhost:8080/gradle-redis \
 -H "Content-Type: application/json" \
 -d '{"identifier": "1010", "name": "gradle-redis 1"}'

curl -s http://localhost:8080/gradle-redis \
 -H "Content-Type: application/json" \
 -d '{"identifier": "1020", "name": "gradle-redis 2"}'

curl -s http://localhost:8080/gradle-redis \
 -H "Content-Type: application/json" \
 -d '{"identifier": "1030", "name": "gradle-redis 3"}'

curl -s http://localhost:8080/gradle-redis \
 -H "Content-Type: application/json" \
 -d '{"identifier": "1040", "name": "gradle-redis 4"}'
```
 
``` 
curl -s http://localhost:8080/gradle-redis/
```

```
curl -s -X PUT http://localhost:8080/gradle-redis \
 -H "Content-Type: application/json" \
 -d '{"identifier": "1010", "name": "gradle-redis 1010-2"}'
```

```
curl -s http://localhost:8080/gradle-redis/1010
```

```
curl -s -X DELETE http://localhost:8080/gradle-redis/1040 
```

---

To run Redis in Docker

```#!/bin/bash
docker run -it \
    --name redis \
    -p 6379:6379 \
    redis:5.0.3
```

---

To install Redis for Windows

You can choose either from these sources
https://github.com/MSOpenTech/redis/releases or
https://github.com/rgl/redis/downloads

Personally I preferred the first option

Download Redis-x64-2.8.2104.zip
Extract the zip to prepared directory

run `redis-server.exe` or `redis-server.exe --maxheap 2gb`

---

To install Redis for Linux

```
$ sudo apt update
$ sudo apt install redis-server
```
To test if Redis is working, run client with command:

```
$ redis-cli
```

Run Start:
```
$ sudo systemctl start redis
```

Connectivity test:
```
127.0.0.1:6379> ping
```
`Output: PONG`

```
127.0.0.1:6379> set test "It's working!"
```
`Output: OK`

```
127.0.0.1:6379> get test
```
`Output: "It's working!"`
