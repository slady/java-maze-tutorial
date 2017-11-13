package ps.java.tutorial.maze.api;

public enum MazeTile {

    FREE('.'),

    WALL('#');

    private final char ch;
    MazeTile(final char ch) {
        this.ch = ch;
    }

    public char getCh() {
        return ch;
    }

}
