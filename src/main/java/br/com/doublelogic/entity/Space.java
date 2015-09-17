package br.com.doublelogic.entity;

/**
 * Created by diegoalvessaidsimao on 17/09/15.
 */
public class Space {

    public static final Space DEFAULT = new Space(new Position(1,1));

    private final Position lowerLeft;
    private final Position upperRight;

    public Space(Position upperRight) {
        lowerLeft = new Position(0, 0);
        this.upperRight = upperRight;
    }

    public Position getLowerLeft() {
        return lowerLeft;
    }

    public Position getUpperRight() {
        return upperRight;
    }

}
