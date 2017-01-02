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
package snake;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Function;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Point2D;
import javafx.util.Duration;

/**
 * Snake game.
 *
 * @author Jakob Hostnik &lt;jakob.hostnik@gmail.com&gt;
 */
public class Snake {
//<editor-fold desc="Fields">

  private Function gameOverFunction;
  private Deque<SnakeElement> snake = new LinkedList<>();
  private final double width;
  private final double height;
  private final Timeline timeline = new Timeline();
  private double currentWay = 0;
  private Integer level = 0;
  private int eatCountDown = 0;

//</editor-fold>
//<editor-fold desc="Getters,Setters">
  /**
   * Gets all parts of snake.
   *
   * @return Deque of SnakeElement.
   */
  public Deque<SnakeElement> getSnake() {
    return snake;
  }

  /**
   * Gets javafx Timeline to pause and unapuse the game.
   *
   * @return timeline
   */
  public Timeline getTimeline() {
    return timeline;
  }

//</editor-fold>
//<editor-fold desc="Methods">
//<editor-fold desc="Public">
  /**
   * Turns snake to the left
   */
  public void turnLeft() {
    currentWay = (currentWay - Math.PI / 20) % (4 * Math.PI);
  }

  /**
   * Turns snake to the right.
   */
  public void turnRight() {
    currentWay = (currentWay + Math.PI / 20) % (4 * Math.PI);
  }

  /**
   * Starts the game
   *
   * @param onFinished Function which is is called on every 10 milis.
   * @param gameOverFuncion Function which is called when game is over.
   */
  public void gameBegin(Function onFinished, Function gameOverFuncion) {
    snake.clear();
    snake.add(new SnakeElement(SnakeElement.ElementType.SNAKE, 3, new Point2D(this.width / 2, this.height / 2)));
    for (int i = 0; i < 20; i++) {
      snake.add(new SnakeElement(SnakeElement.ElementType.SNAKE, 3, new Point2D(this.width / 2 - i * 5, this.height / 2 - i * 5)));
    }
    new SnakeElement(SnakeElement.ElementType.FOOD, 10, new Point2D((Math.random() * width), (Math.random() * height)));
    timeline.getKeyFrames().add(new KeyFrame(Duration.millis(10), (ActionEvent ev) -> {
      this.move();
      onFinished.apply(ev);
    }));
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();
    this.gameOverFunction = gameOverFuncion;
  }
//</editor-fold>

  private void gameOver() {
    snake.clear();
    SnakeElement.getAllElements().clear();
    timeline.stop();
    timeline.getKeyFrames().clear();
    gameOverFunction.apply(level);
  }

  private void move() {
    Point2D newPosition = new Point2D(snake.getLast().getPosition().getX() + Math.cos(currentWay), snake.getLast().getPosition().getY() + Math.sin(currentWay));
    for (SnakeElement e : SnakeElement.getAllElements()) {

      double distance = Math.sqrt(Math.pow(e.getPosition().getX() - newPosition.getX(), 2) + Math.pow(e.getPosition().getY() - newPosition.getY(), 2));
      if (distance <= 3 + e.getRadius() && Arrays.asList(snake.toArray()).indexOf(e) < snake.size() - 10) {
        switch (e.getType()) {
          case FOOD:
            snake.add(new SnakeElement(SnakeElement.ElementType.SNAKE, 6, newPosition));
            SnakeElement.getAllElements().remove(e);
            eatCountDown = 20;
            new SnakeElement(SnakeElement.ElementType.FOOD, 10, new Point2D((Math.random() * width), (Math.random() * height)));
            new SnakeElement(SnakeElement.ElementType.OBSTACLE, 10, new Point2D((Math.random() * width), (Math.random() * height)));
            level++;
            return;
          case BONUS:

            break;
          default:
            gameOver();
            return;
        }
      }
    }
    snake.add(new SnakeElement(SnakeElement.ElementType.SNAKE, 3, newPosition));
    if (eatCountDown > 0) {
      eatCountDown--;
      return;
    }
    SnakeElement.getAllElements().remove(snake.getFirst());
    snake.removeFirst();
  }

//</editor-fold>
//<editor-fold desc="Constructors">
  /**
   * Creates new instance of snake
   *
   * @param width width of play area.
   * @param height height of play area
   */
  public Snake(double width, double height) {
    this.width = width;
    this.height = height;
  }
//</editor-fold>

}
