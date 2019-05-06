package ps.java.tutorial.maze.util;

import ps.java.tutorial.maze.api.Coordinate;
import ps.java.tutorial.maze.api.Direction;
import ps.java.tutorial.maze.api.PathStep;

import java.util.ArrayList;
import java.util.List;

public class DistanceField {

    private final Integer[][] distanceField;

    private final int maxX, maxY;

    public DistanceField(final int x, final int y) {
        distanceField = new Integer[y][x];
        maxX = x;
        maxY = y;
    }

    public Integer get(final int x, final int y) {
        return distanceField[y][x];
    }

    public void add(final Coordinate coordinate, final int distance) {
        distanceField[coordinate.getY()][coordinate.getX()] = distance;
    }

    public List<PathStep> findPath(final Coordinate startCoordinate, final int startValue) {
        final List<PathStep> path = new ArrayList<>();
        int value = startValue;
        Coordinate coordinate = startCoordinate;

        OUTER:
        while (true) {
            for (final Direction direction : Direction.values()) {
                final Coordinate newCoordinate = coordinate.go(direction);
                final int newX = newCoordinate.getX();
                final int newY = newCoordinate.getY();

                if (newX < 0 || newY < 0 || newX >= maxX || newY >= maxY) {
                    continue;
                }

                final Integer newDistance = get(newX, newY);

                if (newDistance == null || newDistance >= value) {
                    continue;
                }

                path.add(new PathStep(direction, coordinate));

                if (newDistance == 0) {
                    return path;
                }

                value = newDistance;
                coordinate = newCoordinate;
                continue OUTER;
            }

            throw new IllegalStateException("Broken path search algorithm!");
        }
    }

}
