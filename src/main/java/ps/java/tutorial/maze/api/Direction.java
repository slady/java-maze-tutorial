package ps.java.tutorial.maze.api;

public enum Direction {

    UP(0, -1, '^'),
    DOWN(0, 1, 'v'),
    LEFT(-1, 0, '<'),
    RIGHT(1, 0, '>');

    private final int x, y;

    private final char ch;

    Direction(final int x, final int y, final char ch) {
        this.x = x;
        this.y = y;
        this.ch = ch;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getCh() {
        return ch;
    }

    @Override
    public String toString() {
        return String.valueOf(ch);
    }

}
