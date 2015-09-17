package br.com.doublelogic.entity;

import br.com.doublelogic.util.Direction;

import java.util.List;

/**
 * Created by diegoalvessaidsimao on 17/09/15.
 */
public class Robot {

    // current robot position
    private Position position;

    // current robot orientation
    private Direction direction;

    // space that can be explored
    private Space space;

    public Robot(Position position, Direction direction, Space space) {
        this.position = position;
        this.direction = direction;
        this.space = space;
    }

    public void move() {
        direction.move(position);
        // can't move outside of space
        if(position.getX() > space.getUpperRight().getX()) {
            position.setX(space.getUpperRight().getX());
        }

        if(position.getX() < space.getLowerLeft().getX()) {
            position.setX(space.getLowerLeft().getX());
        }

        if(position.getY() > space.getUpperRight().getY()) {
            position.setY(space.getUpperRight().getY());
        }

        if(position.getY() < space.getLowerLeft().getY()) {
            position.setY(space.getLowerLeft().getY());
        }
    }

    public void rotateLeft() {
        direction = Direction.rotateLeft(direction);
    }

    public void rotateRight() {
        direction = Direction.rotateRight(direction);
    }

    public void execute(List<String> commands) {
        for(String c : commands) {
            if("E".equalsIgnoreCase(c)) {
                rotateLeft();
            } else if("D".equalsIgnoreCase(c)) {
                rotateRight();
            } else if("A".equalsIgnoreCase(c)) {
                move();
            }
        }
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