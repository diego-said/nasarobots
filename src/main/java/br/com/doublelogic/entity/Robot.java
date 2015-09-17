package br.com.doublelogic.entity;

import br.com.doublelogic.util.Direction;

/**
 * Created by diegoalvessaidsimao on 17/09/15.
 */
public class Robot {

    private Position position;

    private Direction direction;

    public Robot(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public void move() {
        direction.move(position);
    }

    public void rotateLeft() {
        direction = Direction.rotateLeft(direction);
    }

    public void rotateRight() {
        direction = Direction.rotateLeft(direction);
    }

    @Override
    public String toString() {
        return position.getX() + " " + position.getY() + " " + direction;

    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}

