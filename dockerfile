FROM maven:latest

COPY . /app

EXPOSE 8081

CMD [ "mvn", "-f", "/app/pom.xml", "spring-boot:run"]

# docker build --tag webthing-control:1.0 .

# docker network create webthing_network

# docker container create --name webthing-control -p 8081:8081 -e SC_NETWORK=postgres-container -e PG_DATABASE=webthing_db -e DB_USERNAME=noir -e DB_PASSWORD=skripsi20222023 webthing-control:1.0

# docker network connect webthing_network webthing-control