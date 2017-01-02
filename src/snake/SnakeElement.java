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

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point2D;

/**
 * Class for snake elements, such as snake part, food and obstacle.
 *
 * @author Jakob Hostnik &lt;jakob.hostnik@gmail.com&gt;
 */
public class SnakeElement {
//<editor-fold desc="Fields">

  /**
   * Defines the type of snake element
   */
  public static enum ElementType {

    /**
     * Element is snake
     */
    SNAKE,
    /**
     * Element is obstacle
     */
    OBSTACLE,
    /**
     * Element is wall
     */
    OBSTACLE_WALL,
    /**
     * Element is food
     */
    FOOD,
    /**
     * Element is bonus
     */
    BONUS
  }
  private static List<SnakeElement> allElements = new ArrayList<>();
  private final int radius;
  private final ElementType type;
  private Point2D position;
//</editor-fold>
//<editor-fold desc="Getters,Setters">

  /**
   * Gets a type of element.
   *
   * @return type of element
   */
  public ElementType getType() {
    return type;
  }

  /**
   * Gets all elements.
   *
   * @return All snake elements.
   */
  public static List<SnakeElement> getAllElements() {
    return allElements;
  }

  /**
   * Gets a radius of element.
   *
   * @return radius
   */
  public int getRadius() {
    return radius;
  }

  /**
   * Gets the element position
   *
   * @return Point2D position
   */
  public Point2D getPosition() {
    return position;
  }

  /**
   * Sets the element new position.
   *
   * @param position position
   */
  public void setPosition(Point2D position) {
    this.position = position;
  }

//</editor-fold>
//<editor-fold desc="Constructors">
  /**
   * Creates new instance of object.
   *
   * @param type Type of element
   * @param radius Radius of element
   * @param position Position of element
   */
  public SnakeElement(ElementType type, int radius, Point2D position) {
    this.type = type;
    this.radius = radius;
    this.position = position;
    allElements.add(this);
  }
//</editor-fold>

  @Override
  public String toString() {
    return "SnakeElement{" + "type=" + type + ", position=" + position + '}';
  }

}
