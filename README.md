# Twitter Clone in Spring Boot using PostgreSQL
In this project, I tried to develop myself in the java backend. I hope it helps you.<br>
Customize `pom.xml` and `application.properties` files to run the project.
<hr>

## UML DIAGRAM
![UML.png](https://github.com/emrahyilm4z/TwitterClone/blob/master/ScreenShots/uml_diagram.png)
<hr>

## What can you do?
User `ADD`, `UPDATE`, `DELETE` and `FOLLOW` <br>
Tweet `ADD`, `DELETE`, `LIKE`, `RETWEET` and `UPDATE`. You can update within an hour :joy: <br>
<hr>

<details align="left"> 
<summary>Project Architect</summary><br>

    TwitterClone
     ┣ config
     ┃ ┗ GeneralConfig.java
     ┣ controller
     ┃ ┣ FollowerController.java
     ┃ ┣ HomePageController.java
     ┃ ┣ LikesController.java
     ┃ ┣ ReTweetController.java
     ┃ ┣ TweetsController.java
     ┃ ┗ UsersController.java
     ┣ dto
     ┃ ┣ request
     ┃ ┃ ┣ AddTweetRequestDto.java
     ┃ ┃ ┣ AddUserRequestDto.java
     ┃ ┃ ┣ FollowRequestDto.java
     ┃ ┃ ┣ LikeRequestDto.java
     ┃ ┃ ┣ ReTweetRequestDto.java
     ┃ ┃ ┣ UpdateTweetRequestDto.java
     ┃ ┃ ┗ UpdateUserRequestDto.java
     ┃ ┗ response
     ┃ ┃ ┣ AddUserResponseDto.java
     ┃ ┃ ┣ FollowersResponseDto.java
     ┃ ┃ ┣ HomePageResponse.java
     ┃ ┃ ┣ TweetResponseDto.java
     ┃ ┃ ┗ UserResponseDto.java
     ┣ entities
     ┃ ┣ Follower.java
     ┃ ┣ Tweet.java
     ┃ ┗ User.java
     ┣ exception
     ┃ ┣ Message.java
     ┃ ┣ NotFoundTweetID.java
     ┃ ┣ NotFoundUserId.java
     ┃ ┗ NotFoundUserName.java
     ┣ repository
     ┃ ┣ FollowerRepository.java
     ┃ ┣ TweetRepository.java
     ┃ ┗ UserRepository.java
     ┣ service
     ┃ ┣ FollowerService.java
     ┃ ┣ HomePageService.java
     ┃ ┣ LikeService.java
     ┃ ┣ RetweetService.java
     ┃ ┣ TweetService.java
     ┃ ┗ UserService.java
     ┗ TwitterCloneApplication.java
     
 </details>
 <hr>

## POSTMAN REQUESTS
![POSTMAN.png](https://github.com/emrahyilm4z/TwitterClone/blob/master/ScreenShots/postman.png)

- [Import Postman Requests](https://github.com/emrahyilm4z/TwitterClone/blob/master/Twitter%20Clone.postman_collection.json)
<hr>

## DATABASE TABLE
![TABLE.png](https://github.com/emrahyilm4z/TwitterClone/blob/master/ScreenShots/table.png)
<hr>

[MIT](https://github.com/emrahyilm4z/ToDoList/blob/master/LICENSE.txt)
 
