package ps.java.tutorial.maze.util;

import ps.java.tutorial.maze.api.Coordinate;
import ps.java.tutorial.maze.api.Direction;

import java.util.ArrayList;
import java.util.List;

public class DistanceField {

    private final Integer[][] distanceField;

    private final Direction[][] directionField;

    public DistanceField(final int x, final int y) {
        distanceField = new Integer[y][x];
        directionField = new Direction[y][x];
    }

    public Integer get(final int x, final int y) {
        return distanceField[y][x];
    }

    public void add(final Coordinate coordinate, final int distance, final Direction direction) {
        final int x = coordinate.getX();
        final int y = coordinate.getY();
        distanceField[y][x] = distance;
        directionField[y][x] = direction;
    }

    public List<Direction> findPath(final Coordinate coordinate) {
        final List<Direction> path = new ArrayList<>();
        return path;
    }

}
