package ps.java.tutorial.maze;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class MazeTest {

    @Test
    public void read() throws IOException {
        final Maze maze = new Maze("src/test/resources/maze1.txt");
        Assertions.assertEquals(MazeTile.WALL, maze.get(0, 0));
        Assertions.assertEquals(MazeTile.WALL, maze.get(1, 0));
        Assertions.assertEquals(MazeTile.WALL, maze.get(0, 1));
        Assertions.assertEquals(MazeTile.FREE, maze.get(1, 1));
        Assertions.assertEquals(MazeTile.FREE, maze.get(8, 2));
        Assertions.assertEquals(MazeTile.WALL, maze.get(9, 3));
    }

}
