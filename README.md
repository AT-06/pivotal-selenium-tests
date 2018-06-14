# pivotal-tests

[![Build status](https://travis-ci.org/AT-06/pivotal-tests.svg?branch=develop)](https://travis-ci.org/AT-06/pivotal-tests) 

[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=at-06-pivotal-tests&metric=alert_status)](https://sonarcloud.io/dashboard/index/at-06-pivotal-tests)


PIVOTAL-TEST
-----------
pivotal-test is a framework to automate aceptance test cases of the Pivotal-Tracker web page.
This use REST-Assured, cucumber, testNg and selenium.


FEATURES TESTED
---------------

Acceptance tests.

- Login
- Projects
- Stories
    - Tasks
- Workspaces

These features are applied to API and UI.

REQUIREMENTS
-----------------------------------

The required configuration for this framework is the following:

    -IntelliJ idea IDE.
    -Download Gradle 4.5 or superior: https://gradle.org/gradle-download/
    -Clone/download the project from GitHub repository: https://github.com/AT-06/pivotal-tests.git

CONFIGURATIONS
-----------------------------------
Once those requirements are done, follow these steps:

- Open the project downloaded with the IntelliJ IDE.
- Open the Gradle properties file e.g. gradle.properties file

Set the required parameters:

    urlLogin=   //Sales force login URL (e.g. https://login.salesforce.com/) 
    user=       //Sales force user.
    password=   //Sales force Login.
    APIToken=   //Is the token of your pivotal account.
    
    dockerURL=  //Put docker url (e.g. http://url:4444/wb/hub)
    browser=    //Choose only one option.
    
    #Remote Browser SauceLabs/Browserstack properties
    remoteUserName=     //Is the username of Saucelabs or Browserstack.
    remoteAccessKey=    //Is the key provided.
    remoteBrowserName=  //Is The browser that you want to execute your test
    remoteBrowserVersion=
    remoteResolution=   //Screen resolution.
    remotePlatform=     //sauce labs plataform to be remote test.
    remoteOS=        //Is the remote OS name (e.g. Windows)
    #EXPLICIT WAIT 
    explicitWait= //time for wait elements (e.g. 1920x1080).
    

After executing those steps the frame should be executed.

To execute by command line you can use the following:


        gradle clean executeFeatures 
        -PurlLogin="https://www.pivotaltracker.com/signin" -PUser="aaggon411@gmail.com" -PPassw
        ord="P@ssw0rd" -PAPIToken="9ad9814db950835a045d84d5ca9b9f78" -Pbrowser="DOCKER_FIREFOX"
        -PdockerUrl="http://10.28.109.106:4444/wd/hub" -PexplicitWait="30"
   
The project use a coreJavaProject located in https://github.com/AT-06/coreJavaProject that contains the DriverManager, 
browsers configurations and common actions related to web elements.
To use this go to releases section and search the last.
Open build.gradle and change the release version of the coreJavaProject
 
        compile 'com.github.AT-06:coreJavaProject:RELEASE' 

CONTACTS
--------

    -If you want to be informed about new code releases, bug fixes, security fixes, general news and information about
    pivotal-tests project check to the GitHub repository https://github.com/AT-04/pivotal-tests.git

CONTRIBUTORS
------------

Current contributors:

- Jimmy Romero Sejas (JimmyRomero) - https://github.com/JimmyRomero
- Escarleth Ledezma Quiroga (EscarlethFatima) - https://github.com/EscarlethFatima
- Christian Galarza Crespo (Chritian92) - https://github.com/Chritian92
- Daniel Caballero (danielditer) - https://github.com/danielditer
- Maria Canqui Macias (PanDeBatalla94) - https://github.com/PanDeBatalla94
- Ariel Gonzales Vargas (pipo411) - https://github.com/pipo411
- Manuel Valdez Valda (manu863018) - https://github.com/manu863018
- Carlos Gonzales (carledriss) - https://github.com/carledriss