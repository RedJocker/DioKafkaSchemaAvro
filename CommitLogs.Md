
- initial commit, fix avro gradle
    - created checkout module with spring initilizer
    - fixed sdk settings on intelliJ
    - added missing dependencies comparing my build.gradle with tutors build.gradle
    - updated avro version, old version had deprecated warning
    - runned generateAvroJava gradle script
    - application builds without errors 

- CheckoutRequest created
    - created data class CheckoutRequest

- CheckoutCreatedSource created
    - created streaming interface CheckoutCreatedSource

- StreamingConfig created
    - created class for configuration of stream
        - makes @Bean of CheckoutCreatedSource

- CheckoutEntity created with service and repository
    - added jpa and postgress dependencies
    - included database configuration on application.yml
    - created CheckoutEntity
    - created CheckoutRepository
    - created CheckoutService interface
    - created CheckoutServiceImpl 


