Persona - Spring Boot Application
====================================


#### Requirements
1. Java 8
2. Tomcat 8

> apache-maven-3.6.1


#### Intellij IDE Tips
1. Install Lombok Plugin
2. Enable Lombok Annotation Processing
    - File-> Settings
    - Expand `Build, Execution, Deployment`
    - Expand `Compiler`
    - In `Annotation Processors` check **Enable annotation processing**
    - _You may need to re-open the project to get the settings to take effect_.

#### Run it!
```
mvn clean install
```
```
mvn spring-boot:run
```

## Accessing Application
Based on the properties specified to start application, Persona can be accessed at:
```
http://localhost:8186/api/v1/persona
```

## Following are payload

##POST

POST - http://localhost:8186/api/v1/persona

{
    "personaName": "Mast",
    "personaLastName": "Ali",
    "personaAddress": "Beijing China",
    "personaPhoneNum": "008613051429005",
    "personaHairColor": "BLACK"
   
}

##Get All Persona
Get -  http://localhost:8186/api/v1/persona 

##Get Persona By Persona Id
Get - http://localhost:8186/api/v1/persona/1

##Delete Persona By Persona Id
Delete - http://localhost:8186/api/v1/persona/1