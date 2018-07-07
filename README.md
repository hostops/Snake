# SNAKE GAME FRAMEWORK IN JAVA
Project website: https://jakobhostnik.github.io/Snake/
This is simple framework which helps you build snake game. Because java is ment to be general as possible, I seperated framework in two independent modules. Because you cannot use same UI in Android, web and desktop app you can replace only UI. **Game module** runs whole game and **UI module** just uses its functions. Primary point is that you can change UI module and use same framework for Android, web, desktop and even console app. 

### Game module
Game module is located in package **snake**. There are two main classes:
     **Snake** - There are algorythms which actually runs the game. Those algorythms actually controlls "virtual" snake which you can display on your UI.
     **SnakeElement** - Data type for snake elements, such as snake part, food obstacle and walls. You have some predefinned types of snake elements: bonus, food, obstacle, wall, part of snake. Four of them are already implemented: bonus, food, obstacle and snake part. But you can simply add more elements.

### UI module
It has already implemeted UI module for javafx desktop app, but you can simply replace it. Game container is writen and loaded using fxml, but the game itself is added dynamically.
It has graphical **SnakeElement** which converts "virtual" SnakeElement into circle. Main functions are stored in class SnakeFXMLController which handles user inputs.

For more information check project website (https://jakobhostnik.github.io/Snake/), documentation(https://jakobhostnik.github.io/Snake/javadoc) and source (**Snake/src/snake/**).

# Some images
<br/>
<img width="300px" src="https://raw.githubusercontent.com/jakobhostnik/Snake/master/gh-pages/java-snake_files/game.png"/><br/><br/>
<img width="300px" src="https://raw.githubusercontent.com/jakobhostnik/Snake/master/gh-pages/java-snake_files/game1.png"/><br/><br/>
<img width="300px" src="https://raw.githubusercontent.com/jakobhostnik/Snake/master/gh-pages/java-snake_files/game3.png"/><br/><br/>
