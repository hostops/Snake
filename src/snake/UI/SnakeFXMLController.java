/*
 * Copyright (C) 2016 Jakob Hostnik <jakob.hostnik@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package snake.UI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import snake.Snake;
import snake.SnakeElement;

/**
 * Controller for SnakeFXML.fxml file
 *
 * @author Jakob Hostnik &lt;jakob.hostnik@gmail.com&gt;
 */
public class SnakeFXMLController implements Initializable {

  private Snake snake;
  boolean isRunning = false;
  @FXML
  private Pane mainPanel;
  @FXML
  private Label scoreLabel;

  @FXML
  private void newGameButtonClick(ActionEvent event) {
    scoreLabel.setText("");
    isRunning = true;
    if (snake != null) {
      snake.getSnake().clear();
      snake.getTimeline().stop();
      SnakeElement.getAllElements().clear();
    }
    snake = new Snake(mainPanel.getWidth(), mainPanel.getHeight());
    snake.gameBegin(ev -> {
      drawSnake();
      return null;
    }, ev2 -> {
      scoreLabel.setText("Game over! your score: " + ev2.toString());
      return null;
    });

    mainPanel.getScene().setOnKeyPressed((KeyEvent e) -> {
      switch (e.getCode()) {
        case LEFT:
          snake.turnLeft();
          break;
        case RIGHT:
          snake.turnRight();
          break;
      }
    });
  }

  @FXML
  private void pauseButtonAction(ActionEvent event) {
    if (snake != null) {
      if (isRunning) {
        snake.getTimeline().pause();
        isRunning = false;
      } else {
        isRunning = true;
        snake.getTimeline().play();
      }
    }
  }

  @FXML
  private void resetButtonAction(ActionEvent event) {
    if (snake != null) {
      scoreLabel.setText("");
      snake.getSnake().clear();
      snake.getTimeline().stop();
      SnakeElement.getAllElements().clear();
      drawSnake();
    }
  }

  private void drawSnake() {
    mainPanel.getChildren().clear();
    SnakeElement.getAllElements().stream().forEach((e) -> {
      SnakeUIElement uie = new SnakeUIElement(e);
      mainPanel.getChildren().add(uie);
    });
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {

  }

}
