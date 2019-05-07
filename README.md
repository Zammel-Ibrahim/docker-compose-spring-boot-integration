# Spring Boot app deployement  using Docker Compose

0- installing dockerCE and docker compose: 
sudo apt-get remove docker docker-engine docker.io containerd runc
sudo apt-get update

sudo apt-get install \
    apt-transport-https \
    ca-certificates \
    curl \
    gnupg-agent \
    software-properties-common
    
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo apt-key fingerprint 0EBFCD8    

sudo apt-get install docker-ce docker-ce-cli containerd.io

apt-cache madison docker-ce
docker run hello-world

sudo curl -L "https://github.com/docker/compose/releases/download/1.24.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

sudo chmod +x /usr/local/bin/docker-compose

docker-compose --version



1. Prepare  a `Dockerfile` for creating an image from the jar Application

`FROM openjdk:8
VOLUME /tmp
ADD target/springboot-docker-compose.jar springboot-docker-compose.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "springboot-docker-compose.jar"]`

2. Create docker-compose.yml 

`version: '3'
services:
  springboot-docker-compose-app-container:
    image: springboot-docker-compose-app:1
    build:
      context: ./
      dockerfile: Dockerfile
    volumes:
      - /data/springboot-docker-compose-app
    ports:
      - "8082:8082"`


3. Create the Docker image (springboot-docker-compose) and start application using docker compose created in  step 2.
`docker-compose up`

4. Stop docker container
`docker-compose down`


## Some Useful Docker commands : 
- `docker images`
- `docker container ls`

