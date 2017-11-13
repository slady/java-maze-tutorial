package ps.java.tutorial.maze.api;

public class PathStep {

    private final Direction direction;

    private final Coordinate coordinate;

    public PathStep(final Direction direction, final Coordinate coordinate) {
        this.direction = direction;
        this.coordinate = coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

}
