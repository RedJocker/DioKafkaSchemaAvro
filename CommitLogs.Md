
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
    

