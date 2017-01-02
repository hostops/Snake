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

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import snake.SnakeElement;

/**
 * Snake element as part of user interface.
 *
 * @author Jakob Hostnik &lt;jakob.hostnik@gmail.com&gt;
 */
public class SnakeUIElement extends Circle {

  SnakeUIElement(SnakeElement e) {
    Color color = Color.BLUE;
    switch (e.getType()) {
      case SNAKE:
        color = Color.BLACK;
        break;
      case OBSTACLE:
        color = Color.RED;
        break;
      case OBSTACLE_WALL:
        color = Color.RED;
        break;
      case FOOD:
        color = Color.GREEN;
        break;
      case BONUS:
        color = Color.PURPLE;
        break;
    }
    this.setRadius(e.getRadius());
    this.setLayoutX(e.getPosition().getX());
    this.setLayoutY(e.getPosition().getY());
    this.setFill(color);

  }
}
