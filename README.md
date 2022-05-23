# Rest-Assured-API
<img src="https://qaautomationexpert.files.wordpress.com/2021/05/image-103.png?w=615" width="300" height="150">

<img src="https://junit.org/junit4/images/junit5-banner.png" width="300" height="100">

<img src="https://avatars.githubusercontent.com/u/5879127?s=200&v=4" width="100" height="100">

#### Required software
    WIP

#### How to Run and Generate report
    mvn clean test -Dtest=TAGS allure:report or mvn clean test allure:report

 TAGS | EXAMPLES |
| :---: | :---: |
| all_examples | mvn clean test -Dtest=all_examples allure:report |
| status_code | mvn clean test -Dtest=status_code allure:report |
| checking_body_example | mvn clean test -Dtest=checking_body_example allure:report |

#### Generate report after run
    mvn allure:serve

#### Libraries
    rest-assured - 5.0.1 <=> Library to test REST APIs
    junit-jupiter - 5.8.2<=> To support test creation
    allure-maven - 2.8 <=> Generate report

#### links
    Allure: https://docs.qameta.io/allure/
    https://javabydeveloper.com/junit-5-with-allure-reports-example/