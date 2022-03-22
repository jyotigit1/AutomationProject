@ui @healthcheck @AutomationProject
Feature: E-commerce Web Application Health Check

@UrlValidation 
  Scenario: User opend browser and navigate to the home page URL and validated the home page url 
    Given  User validate Application URL
    When   User open URL and validate
    Then   User redirected to index page
 
 @UrlLogoVisibility
  Scenario: The Application logo is Displayed with width and height 
     Given User validate Application URL
     And   User open index page
     When   The Application logo is displayed
     Then   The Application logo width is 350 and height is 99
     
 @ProductCategory  
  Scenario: The Application product main category list validation
    Given  User validate Application URL
    Then  Validate main product categories count should be 3
     And   Text the displayed 3 categories is shown below
  
 @SearchFunctionality   
   Scenario: The Application Search Functionality
    Given  User validate Application URL
    And    User open index page
    When  User Search for product "<Product_Name>"
    Then  The search result page is displayed
    
     Examples:
     |Product_Name|
     |  T-shirt   |
     |  Womens    |
     |  Dresses   |
     
  @CheckFooterLink 
    Scenario: Application social media handles validation
     Given  User validate Application URL
     When  User click on footer link 
     Then  Twitter account will open in new tab 
    
     