
- initial commit, fix avro gradle
    - created checkout module with spring initilizer
    - fixed sdk settings on intelliJ
    - added missing dependencies comparing my build.gradle with tutors build.gradle
    - updated avro version, old version had deprecated warning
    - runned generateAvroJava gradle script
    - application builds without errors 
<br>

- CheckoutRequest created
    - created data class CheckoutRequest
<br>

- CheckoutCreatedSource created
    - created streaming interface CheckoutCreatedSource
<br>

- StreamingConfig created
    - created class for configuration of stream
        - makes @Bean of CheckoutCreatedSource
<br>

- CheckoutEntity created with service and repository
    - added jpa and postgress dependencies
    - included database configuration on application.yml
    - created CheckoutEntity
    - created CheckoutRepository
    - created CheckoutService interface
    - created CheckoutServiceImpl 
    - created docker-compose.yml
        - added postgress
    - application runs but can't find kafka
        - todo: add kafka to docker-compose  
<br>

- added kafka to docker-compose.yml
    - added zookeeper
    - added kafka
    - added schema-registry
    - added cloud config in application.yml
<br>

 - created CheckoutResource
    - 2 endpoints implemented
        -  createFromForm, consumes application/x-www-form-urlencoded
            - receiving the requests but not being able to get the values from the form
        - createFromJson, consumes aplication/json
            - working as expected
    - application runs and receives requests on the endpoints implemented
    - todo: 
        - fix createFromForm
<br>

- fix createFromForm
    - problem was mainly on front-end missing atributte name on form parameters
        - fixed tutors front-end
    - included frontend in projects folder
        - besides the fix it was all writen by tutor
    - fixed checkoutEntity
        - typo and missing atribute 
<br>

- improved response on both endpoints
    - createFromForm
        - redirects to a page with the code as a String
    - createFromJson
        - receives a { "code": "dfsafasfa"}
            - used map instead of a pojo
<br>

- produce a kafka message
    - had a hard-time with serialization issues
        - for some reason the application.yml was not being able to set the serializer to KafkaAvroSerializer and Jackson kept crashing during serialization with "not an array" message
        - found a solution by doing a more manual aproach to sending the message
            - not the best solution, ideally would like to be able to make proper configuration and make use of abstractions provided by the framework, or at least organize a little better the solution that is currently implemented
        - this bug took a whole day and I still want to deliver this and two other projetcs by the end of the week to conclude the bootcamp, today is thursday already
    - message produced
        - checked by entering kafka container and running a console consumer
<br>



