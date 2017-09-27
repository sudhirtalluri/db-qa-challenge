# Introduction
The goal is to test www.etsy.com using the template provided on https://github.com/soap6gal/test-developer-interview-stage-1. 
 
The tasks are:
 
1. To implement the remaining two scenarios tagged as @wip in the search.feature file. The first two scenarios have been implemented to serve as examples of implementing the tests via Page Object and Screenplay patterns. Candidates may use either pattern and modify the framework as they see fit.
2. To write and implement a few more BDD scenarios for UI and API tests to demonstrate candidates understanding of what scenarios are best for UI and what scenarios are best for API tests. Tips: Refer to Reference #2 for API tests.
3. Good to have but not required: How to run the tests in parallel, with batch strategy, etc.
4. Any other improvements / suggestions. 
 
Candidates are encouraged to use the given framework but welcome to use their own framework (in Java/Javascript) however clear instructions on how to use and run the tests and why the framework is better should also be provided.

References:
1. http://serenity-bdd.info/docs/serenity/
2. https://github.com/rest-assured/rest-assured/wiki/Usage

Tips: 
1. Try not to hard-code any locator and driver paths ;)

## How to customize this project
 
Edit serenity.properties to make changes specific to your needs.

## Running tests

To run all tests, run the command below:

`$ gradle clean test aggregate`

To run scenarios tagged as pageobject OR screenplay on Chrome: 

`$ gradle clean test aggregate -Dwebdriver.driver=chrome -Dcucumber.options="--tags @pageobject,@screenplay"` 

To run scenarios tagged as ui AND NOT wip on Safari: 
`$ gradle clean test aggregate -Dwebdriver.driver=safari -Dwebdriver.base.url=http://abc.com -Dcucumber.options="--tags @ui --tags ~@wip"`

## Reporting

View the report at target/site/serenity/index.html



## Running Test in Parallel 
We are currently using cucumber-jvm-parallel-plugin to run the tests in parallel, Could not Implement this in given time line
Or other way we can do this by creating by multiple jobs in jenkins and use different tag for each job

## UI Tests to be covered
Sorry lack of time could not cover few more scenarios as below

  Search results apply different filters(Eg Category/On Sale/Location/Price/Colour/Shipping destination )
  UI Tests to be covered as below
  Testing pagination/items per page

Perform different type of search apply different type of filters and validate results
  Testing front end  pagination


 Below UI test scenarios with and with out logged in
 Adding items to cart from Search Results/Icons/Categories
 Calculating basket prices
 Delete Items from cart
 Update basket item quantities
 Apply Discount codes
 Place an order with different type of payment methods(Eg. Visa, Master, Debit, Credit, Paypal, Voucher codes and so on)
 Update orders with Address Change, Delivery date change and so on
 Cancel Order
 Refunds
 
 ## API Tests to be covered
 Sorry lack of time could not cover few more scenarios
  API Tests to be covered as part of API testing I could think of as below
 User registration  API tests build the user in the fly with json builder and create user(This is user for frontend logged in tests as well)
   Perform different type of search
   Testing pagination
   Login through API get the Authentication token use it for other requests
 
   Adding items to cart from Search Results/Icons/Categories
   Calculating basket prices
   Delete Items from cart
   Update basket item quantities
   Apply Discount codes
 
 
   Place an order with different type of payment methods(Eg. Visa, Master, Debit, Credit, Paypal, Voucher codes and so on)
   Update orders with Address Change, Delivery date change and so on
   Cancel Order
   Refunds
 Perform schema validation tests for all endpoints

 ## Notes:
 Created this class SerenityFacade setDate() or getData() to store or transfer date between steps and classes
 I've created BaseService make any rest calls and HTTPMethods enum class to mare rest calls
 Test results can be found in this file TestResults.rtf
 Sorry If I miss anything, Please let me know if you anything
 
 
 
 