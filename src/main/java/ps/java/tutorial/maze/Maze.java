package ps.java.tutorial.maze;

import ps.java.tutorial.maze.api.Coordinate;
import ps.java.tutorial.maze.api.Direction;
import ps.java.tutorial.maze.api.MazeTile;
import ps.java.tutorial.maze.api.PathStep;
import ps.java.tutorial.maze.util.DistanceField;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Maze {

    private final MazeTile[][] maze;

    public Maze(final String fileName) throws IOException {
        final List<String> lines = new ArrayList<>();
        int maxWidth = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(new File((fileName))))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
                if (line.length() > maxWidth) {
                    maxWidth = line.length();
                }
            }
        }

        final int height = lines.size();
        maze = new MazeTile[height][maxWidth];
        for (int y = 0; y < height; y++) {
            final String line = lines.get(y);
            int width = line.length();
            for (int x = 0; x < width; x++) {
                final char ch = line.charAt(x);
                if ('#' == ch) {
                    maze[y][x] = MazeTile.WALL;
                } else {
                    maze[y][x] = MazeTile.FREE;
                }
            }
        }
    }

    public MazeTile get(final int x, final int y) {
        return maze[y][x];
    }

    public List<PathStep> findPath(final Coordinate coordinateStart, final Coordinate coordinateFinish) {
        final int maxY = maze.length;
        final int maxX = maze[0].length;
        final DistanceField distanceField = new DistanceField(maxX, maxY);
        List<Coordinate> oldList = new ArrayList<>();
        oldList.add(coordinateFinish);
        distanceField.add(coordinateFinish, 0);

        for (int i = 1; !oldList.isEmpty(); i++) {
            final List<Coordinate> newList = new ArrayList<>();

            for (final Coordinate coordinate : oldList) {
                for (final Direction direction : Direction.values()) {
                    final Coordinate newCoordinate = coordinate.go(direction);
                    final int newX = newCoordinate.getX();
                    final int newY = newCoordinate.getY();

                    if (newX < 0 || newY < 0 || newX >= maxX || newY >= maxY) {
                        continue;
                    }

                    if (distanceField.get(newX, newY) != null || this.get(newX, newY) == MazeTile.WALL) {
                        continue;
                    }

                    if (newX == coordinateStart.getX() && newY == coordinateStart.getY()) {
                        return distanceField.findPath(coordinateStart, i);
                    }

                    newList.add(newCoordinate);
                    distanceField.add(newCoordinate, i);
                }
            }

            oldList = newList;
        }

        return null;
    }

    public String printWithPath(final List<PathStep> path) {
        final StringBuilder buf = new StringBuilder();
        final Map<Integer, Map<Integer, Direction>> map = path.stream().collect(
                Collectors.groupingBy(
                        step -> step.getCoordinate().getY(),
                        Collectors.toMap(
                                step -> step.getCoordinate().getX(),
                                PathStep::getDirection)));

        final int maxY = maze.length;
        final int maxX = maze[0].length;

        for (int y = 0; y < maxY; y++) {
            final Map<Integer, Direction> mapY = map.get(y);

            for (int x = 0; x < maxX; x++) {
                if (mapY != null && mapY.containsKey(x)) {
                    buf.append(mapY.get(x).getCh());
                } else {
                    buf.append(get(x, y).getCh());
                }
            }

            buf.append('\n');
        }

        return buf.toString();
    }

}
