:seedling: This is just a basic framework under development for automating REST APIs .

 Designed specifically for `fork` project.  :fork_and_knife::chopsticks::spoon::plate_with_cutlery:

**How to run test locally**  :desktop_computer:   

1. Go to the project folder `fork-api` where `pom.xml` file is present.
2. Open terminal/CMD in this folder.
3. Run command **mvn clean install**

the test suite execution will start and you can see the execution report under **test-result** folder that will be generated after run (refresh project folder if you don't see it).


**How to run test using github actions**    :rocket:   
I have created a github workflow for this project to run the tests   
On this repository   
1. Go to Actions tab in this repository
2. Click on workflow `Fork API Automation`
3. Click on `Run workflow` dropdown 
4. Click on green `Run workflow` button   

Refresh the browser and you can see that run has been started. Check logs of the tests by going inside this running workflow.   
You can also download the `test-result` folder present inside `Artifact` block in last github workflow run and see the extent HTML report.

Cheers :shipit: :tada:

