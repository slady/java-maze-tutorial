package ps.java.tutorial.maze.api;

public class Coordinate {

    private final int x;

    private final int y;

    public Coordinate(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Coordinate)) {
            return false;
        }

        final Coordinate other = (Coordinate) obj;

        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return x + 1000 * y;
    }

    public Coordinate go(final Direction direction) {
        return new Coordinate(x + direction.getX(), y + direction.getY());
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
