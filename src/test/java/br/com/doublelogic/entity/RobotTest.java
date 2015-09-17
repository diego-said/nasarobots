package br.com.doublelogic.entity;

import br.com.doublelogic.util.Direction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by diegoalvessaidsimao on 17/09/15.
 */
public class RobotTest {

    private Robot robot;

    @Before
    public void cleanData() {
        robot = new Robot(new Position(0, 0), Direction.NORTH);
    }

    @Test
    public void testOutput() {
        assertEquals("0 0 N", robot.toString());
    }

    @Test
    public void testSequence() {
        robot.rotateLeft();
        robot.move();
        robot.rotateLeft();
        robot.move();
        robot.rotateLeft();
        robot.move();
        robot.rotateLeft();
        robot.move();
        robot.move();
        assertEquals(Direction.NORTH, robot.getDirection());
        assertEquals(0, robot.getPosition().getX());
        assertEquals(1, robot.getPosition().getY());
    }

}
