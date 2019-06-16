# evertrue-challenge
Etrue Code Challenge

# How to run

# About service

# Technologies Used
- SpringBoot 
- Spring Web
- Swagger API Document
- h2 - memory based DB (for the frist iteration)
- IntelliJ IDE
- Java 1.8 (per Req)
- Maven 
- Log4j2

# API Contract
  - .../api/v1/admin/selfservice {Admin Credentials Needed}
  - .../api/vi/careers
  	- history/{EmployeeId} : GET : LIST<CareerInfo>
	- .../api/v1/company
		- retention/{CompanyName} : GET : LIST<Company>  : view Retention Object
		- tenured/{CompanyName} : GET : LIST<Company>	:	
	
# Resources / Entities
- companies
- careers
- employee
- employee_careers : programatically loaded : denormalized for easy querying and performance

# Endpoints:
- To access the API
- To run admin task
- To view API health, configuration etc
- Accessing Swagger UI
    - http://localhost:9090/swagger-ui.html
        - /admin
- view / acces h2 database
    - http://localhost:9090/h2-console
    - username / password : admin / admin

# Bonus

