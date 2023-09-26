@centricstore
Feature: Demonstrate the use of inline data in Cucumber steps

    @store
    Scenario: Search and Buy Products with Varying Credit Cards, Shipping, and Products
        Given I have launched the site
        And I have searched for "<search_field>"
        And I have added "<search_field>" to my cart
        And I begin the checkout process as a guest
        When I enter billing address information like "<first_name>","<last_name>","<email>","<country>","<state>","<city>","<address1>","<zip>","<phone>"
        And I pay via details like "<cc_name>","<cc_number>","<cc_month>","<cc_year>","<cc_cvc>"
        And I confirm order totalling "<price>"
        Then I will receive a confirmation

        Examples:
            | search_field | first_name | last_name | email           | country       | state | city     | address1    | zip   | phone        | cc_name    | cc_number        | cc_month | cc_year | cc_cvc | price   |
            | HTC          | John       | Smith     | kma@hotmail.com | United States | Ohio  | Columbus | 123 Main St | 43215 | 614-555-1212 | John Smith | 4111111111111111 | 03       | 2023    | 245    | $100.00 |
            | Adobe        | John       | Smith     | kma@hotmail.com | United States | Ohio  | Columbus | 123 Main St | 43215 | 614-555-1212 | John Smith | 378282246310005  | 03       | 2023    | 1234   | $75.00  |


    @testscenario2
    Scenario: Search and Buy Products with Varying Credit Cards, Shipping, and Products
        Given I have launched the site
        And I have searched for product
            | search_field | HTC |
        And I have added product to my cart
            | search_field | HTC |
        And I begin the checkout process as a guest
        When I enter billing address information like
            | first_name | John            |
            | last_name  | Smith           |
            | email      | kma@hotmail.com |
            | country    | United States   |
            | state      | Ohio            |
            | city       | Columbus        |
            | address1   | 123 Main St     |
            | zip        | 43215           |
            | phone      | 614-555-1212    |
        And I pay via details like
            | cc_name   | John Smith       |
            | cc_number | 4111111111111111 |
            | cc_month  | 03               |
            | cc_year   | 2023             |
            | cc_cvc    | 245              |
        And I confirm order totalling "$100.00"
        Then I will receive a confirmation