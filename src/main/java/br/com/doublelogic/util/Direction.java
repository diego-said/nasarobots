package br.com.doublelogic.util;

import br.com.doublelogic.entity.Position;

/**
 * Created by diegoalvessaidsimao on 17/09/15.
 */
public enum Direction {

    NORTH("N"), SOUTH("S"), EAST("L"), WEST("O");

    private String symbol;

    Direction(String symbol) {
        this.symbol = symbol;
    }

    public static Direction rotateLeft(Direction d) {
        switch (d) {
            case NORTH:
                return WEST;
            case WEST:
                return SOUTH;
            case SOUTH:
                return EAST;
            case EAST:
                return NORTH;
        }
        return null;
    }

    public static Direction rotateRight(Direction d) {
        switch (d) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
        }
        return null;
    }

    public void move(Position pos) {
        switch (this) {
            case NORTH:
                pos.setY(pos.getY() + 1);
                break;
            case SOUTH:
                pos.setY(pos.getY() - 1);
                break;
            case EAST:
                pos.setX(pos.getX() + 1);
                break;
            case WEST:
                pos.setX(pos.getX() - 1);
                break;
        }
    }

    @Override
    public String toString() {
        return symbol;
    }
}
