package br.com.doublelogic.util;

import br.com.doublelogic.entity.Position;
import br.com.doublelogic.util.Direction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static br.com.doublelogic.util.Direction.NORTH;
import static br.com.doublelogic.util.Direction.SOUTH;
import static br.com.doublelogic.util.Direction.WEST;
import static br.com.doublelogic.util.Direction.EAST;

/**
 * Created by diegoalvessaidsimao on 17/09/15.
 */
public class DirectionTest {

    private Position pos;

    @Before
    public void cleanData() {
        pos = new Position(0 ,0);
    }

    @Test
    public void testRotateLeft() {
        assertEquals(WEST, Direction.rotateLeft(NORTH));
    }

    @Test
    public void testRotateRight() {
        assertEquals(WEST, Direction.rotateRight(SOUTH));
    }

    @Test
    public void testMoveNorth() {
        NORTH.move(pos);
        assertEquals(0, pos.getX());
        assertEquals(1, pos.getY());
    }

    @Test
    public void testMoveSouth() {
        SOUTH.move(pos);
        assertEquals(0, pos.getX());
        assertEquals(-1, pos.getY());
    }

    @Test
    public void testMoveWest() {
        WEST.move(pos);
        assertEquals(-1, pos.getX());
        assertEquals(0, pos.getY());
    }

    @Test
    public void testMoveEast() {
        EAST.move(pos);
        assertEquals(1, pos.getX());
        assertEquals(0, pos.getY());
    }

}