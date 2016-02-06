# Twitter Analytics Web Service

Description
-----------

This is a term project from course 15619 Cloud Computing @ Carnegie Mellon University. The goal of this project is to practice integrating all parts learned from the course in designing, developing and deploying a real working solution.

Plan
----
Based on our experiences on web development and descriptions metioned above, we take Feb, 2016 as the 1st stage with the primary goal of prototyping our own chat application following the Development Guildlines metioned below. Here're some tentative schedules.

[2016/02/01 - 2016/02/07] Project Selection, Plan Discussion, and Proposal Draft Writing
[2016/02/08 - 2016/02/29] System Design, Resource Discovery, Project Implementation, Document Writing
[2016/03/01 - 2016/03/04] User Manual Writing and Video Presentation Making

Resource
--------
Class materials: The dataset collected from Twitter. Each file contains roughly 20,000 tweets stored in JSON format.

Language & Framework
--------------------
+ Front-end: JavaScript
+ Back-end: Java
+ Database: HBase or MySQL

Development Guildlines 
----------------------
The web service solution should provide data statistics on the twitter dataset. Users can submit
queries about tweets based on userids or time.

- Front end should be able to receive and respond to queries.
  * The web service’s front end will have to handle the following query types through HTTP GET requests on port 80:
     1. Heartbeat (q1)
     2. Text of tweets (q2)
     3. Number of tweets (q3)
     4. Who retweeted a tweet (q4)

- Back end system is used to store the data to be queried.
  * Spot instances for the back end system development
  * On demand instances for the live test.

- ETL(Data extract, transform and load)

Owner
-----
@team: Octupus team member: @tianwenlan @
