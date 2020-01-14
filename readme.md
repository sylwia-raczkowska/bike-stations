# Bike stations

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

To run this application on your local machine you can execute the `main` method in the `om.raczkowska.citynav.CityNavApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Example usage

###Creating station
Example request:

    curl -X POST \
      http://localhost:8080/api/station \
      -H 'content-type: application/json' \
      -d '{
      "name": "Garbary"
    }

### Adding bike to a station
Example request:

    curl -X PUT \
      http://localhost:8080/api/station/1/bike \
      -H 'content-type: application/json' \
      -d '{
      "positionId": 5
    }'

where 1 is a stationId

### Renting a bike from a station
Example request:

    curl -X PUT \
      http://localhost:8080/api/station/1/bike/2 \
      -H 'content-type: application/json' \
      

where 1 is a stationId and 2 is a bikeId

### Returning a bike to station
Example request:

    curl -X PUT \
      http://localhost:8080/api/station/bike/2 \
      -H 'content-type: application/json' \
      -d '{
    	"stationId": 1,
    	"positionId": 5
    }'
      

where 2 is a bikeId
