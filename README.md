# assessment
Charter assessment


These are the steps to run this app.
1) set up the database
     it expects a schema named assessment and a user name applicant
     the tables will be created on running the unit tests
2) build application (with tests) with  -- mvnw clean install
3) run application -- mvnw spring-boot:run
4) the api to hit in this order
      1) Add data with http://localhost:8080/addRewardsData
      2) Get the rewards data - http://localhost:8080/getRewardsData


