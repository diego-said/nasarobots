import br.com.doublelogic.entity.Position;
import br.com.doublelogic.entity.Robot;
import br.com.doublelogic.entity.Space;
import br.com.doublelogic.util.Direction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by diegoalvessaidsimao on 17/09/15.
 */
public class NasaRobots {

    public static void main(String[] args) {
        Path path = Paths.get("/Users/diegoalvessaidsimao/Desenv/Java/git/nasarobots/src/main/resources", "input.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            if(lines != null && lines.size() > 0) {
                // get the upper right position
                List<Integer> upperRightPosition = getNumbers(lines.get(0));
                Position upperRight = new Position(upperRightPosition.get(0), upperRightPosition.get(1));

                // space to explore
                final Space space = new Space(upperRight);

                for(int i = 1; i < lines.size(); i += 2) {
                    List<String> startPosition = getRobotStartPosition(lines.get(i));
                    List<String> commands  = getCommands(lines.get(i + 1));

                    Position position = new Position(Integer.valueOf(startPosition.get(0)),
                            Integer.valueOf(startPosition.get(1)));

                    Direction direction = Direction.getDirection(startPosition.get(2));
                    
                    Robot robot = new Robot(position, direction, space);
                    robot.execute(commands);

                    System.out.println(robot.toString());
                }
            } else {
                System.out.println("bad input");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> getNumbers(String s) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(s);
        List<Integer> numbers = new ArrayList<>();
        while (matcher.find()) {
            numbers.add(Integer.valueOf(matcher.group()));
        }
        return numbers;
    }

    private static List<String> getRobotStartPosition(String s) {
        Pattern pattern = Pattern.compile("[0-9]|[nNsSlLoO]");
        Matcher matcher = pattern.matcher(s);
        List<String> data = new ArrayList<>();
        while (matcher.find()) {
            data.add(matcher.group());
        }
        return data;
    }

    private static List<String> getCommands(String s) {
        Pattern pattern = Pattern.compile("[eEdDaA]");
        Matcher matcher = pattern.matcher(s);
        List<String> commands = new ArrayList<>();
        while (matcher.find()) {
            commands.add(matcher.group());
        }
        return commands;
    }

}