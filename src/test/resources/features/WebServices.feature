Feature: webservices Feature

#@webservices
#Scenario Outline: Test Get API with path parameter
#Given user hit the endpoint url "<URL>" with "<Type>" call
#Then User verifies the responsecode with <Responsecode>  

#Examples: 
#|URL												|Responsecode|Type|
#|https://reqres.in/api/users|200				 |Get |


Scenario Outline: Test Get API with query parametrs 
Given user hit the endpoint url "<URL>" with "<Type>" call
#Then User verifies the value of "<field>" field with "<value>" having <index>  
Then User verifies the value of "<field1>" field with "<value1>" 

Examples: 
|URL												 				|index				|field			|value		|Type|field1|value1|
|https://reqres.in/api/users?page=2 |0				    |last_name  |Lawson   		|Get |total |12    |


#Scenario Outline: Test Post API with query parametrs 
#Given user hit the endpoint url "<URL>" with "<Type>" call

#Examples: 
#|URL												 |Type|
#|https://reqres.in/api/users |Post|