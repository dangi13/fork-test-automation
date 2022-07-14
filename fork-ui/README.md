 :seedling: This is just a basic framework under development for automating of Web applications.  `Java` `Selenium` `TestNG` `ExtentReports`

 Designed specifically for `fork` project.   :fork_and_knife::chopsticks::spoon::plate_with_cutlery:   

**How to run test locally** :desktop_computer:    

1. Go to the project folder `fork-ui` where `pom.xml` file is present.
2. Open terminal/CMD in this folder.   
3. Run command **mvn clean install**   

the test suite execution will start and you can see the execution report under **test-result** folder.

**How to run test on BrowserStack**   :cloud_with_lightning_and_rain:   :rocket:   
I have created a github workflow for this project that will execute the script on BrowserStack  

On this repository   

1. Go to Actions tab in this repository
2. Click on workflow `Fork UI Automation`
3. Click on `Run workflow` dropdown 
4. Click on green `Run workflow` button   

Login to browserstack to see results, follow below steps   
Sign in: [BrowserStack](https://www.browserstack.com/users/sign_in )  
[Username]: gawolo8548@satedly.com   
[Password]: Fork@123   
Now go to [dashboard](https://automate.browserstack.com/dashboard/v2/builds)  to check your run. You can see here video of your execution and all the logs. 

You can also download the `test-result` folder present inside `Artifact` block in last github workflow run and see the extent HTML report.   

Cheers :shipit: :tada:


