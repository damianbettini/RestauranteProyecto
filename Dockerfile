FROM openjdk:19
COPY target/RestoranteOstrovskyBettini-0.0.1-SNAPSHOT.jar RestoranteOstrovskyBettini.jar
ENTRYPOINT ["java","-jar","/RestoranteOstrovskyBettini.jar"]