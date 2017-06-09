# SNAKE GAME FRAMEWORK IN JAVA
Project website: http://java-snake.com-1.rf.gd
This is simple framework which helps you build snake game. Because java is ment to be universal, I seperated framework in two independent modules. Problem is you cannot use same UI in Android, web and desktop app. **Game module** runs whole game and **UI module** implements it. Main point is that you can change UI module and use same framework for Android, web, desktop and even console app. 

### Game module
Game module is located in package **snake**. There are two main classes:
     **Snake** - there are algorythms which actually runs the game. Those algorythms actually controlls "virtual" snake which you can display on your UI.
     **SnakeElement** - Data type for snake elements, such as snake part, food obstacle and walls. You have some predefinned types of snake elements: bonus, food, obstacle, wall, part of snake. Four of them are already implemented: bonus, food, obstacle and snake part. But you can simply add more elements and implement them.

### UI module
It has already implemeted UI module for desktop app, but you can simply replace it. It uses javafx. Game container is writen and loaded using fxml, but the game is added dinamicly.
It has also graphical **SnakeElement** which converts "virtual" SnakeElement into circle. Main functions are stored in class SnakeFXMLController which handles user inputs.

For more information check project website(http://java-snake.com-1.rf.gd), documentation(http://java-snake.com-1.rf.gd/javadoc/index.html) and source (**Snake/src/snake/**).

# Some images
<br/>
<img width="300px" src="https://github.com/jakobhostnik/Snake/blob/master/src/snake/Java-snake-website(java-snake)/java-snake_files/game.png?raw=true"/><br/><br/>
<img width="300px" src="https://github.com/jakobhostnik/Snake/blob/master/src/snake/Java-snake-website(java-snake)/java-snake_files/game1.png?raw=true"/><br/><br/>
<img width="300px" src="https://github.com/jakobhostnik/Snake/blob/master/src/snake/Java-snake-website(java-snake)/java-snake_files/game3.png?raw=true"/><br/><br/>