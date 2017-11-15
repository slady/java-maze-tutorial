package ps.java.tutorial.maze.test;

import org.junit.Assert;
import org.junit.Test;
import ps.java.tutorial.maze.api.Coordinate;
import ps.java.tutorial.maze.api.Direction;
import ps.java.tutorial.maze.Maze;
import ps.java.tutorial.maze.api.MazeTile;
import ps.java.tutorial.maze.api.PathStep;

import java.io.IOException;
import java.util.List;

public class MazeTest {

    @Test
    public void read1() throws IOException {
        final Maze maze = new Maze("src/test/resources/maze1.txt");
        Assert.assertEquals(MazeTile.WALL, maze.get(0, 0));
        Assert.assertEquals(MazeTile.WALL, maze.get(1, 0));
        Assert.assertEquals(MazeTile.WALL, maze.get(0, 1));
        Assert.assertEquals(MazeTile.FREE, maze.get(1, 1));
        Assert.assertEquals(MazeTile.FREE, maze.get(8, 2));
        Assert.assertEquals(MazeTile.WALL, maze.get(9, 3));
    }

    @Test
    public void read2() throws IOException {
        final Maze maze = new Maze("src/test/resources/maze2.txt");
        Assert.assertEquals(MazeTile.WALL, maze.get(0, 0));
        Assert.assertEquals(MazeTile.WALL, maze.get(1, 0));
        Assert.assertEquals(MazeTile.WALL, maze.get(0, 1));
        Assert.assertEquals(MazeTile.FREE, maze.get(1, 1));
        Assert.assertEquals(MazeTile.FREE, maze.get(8, 2));
        Assert.assertEquals(MazeTile.WALL, maze.get(9, 2));
        Assert.assertEquals(MazeTile.WALL, maze.get(9, 3));
        Assert.assertEquals(MazeTile.WALL, maze.get(8, 4));
        Assert.assertEquals(MazeTile.FREE, maze.get(8, 5));
    }

    @Test
    public void coordinate() {
        final Coordinate coordinate1 = new Coordinate(1, 1);
        final Coordinate coordinate2 = new Coordinate(1, 1);
        final Coordinate coordinate3 = new Coordinate(2, 2);

        Assert.assertEquals(coordinate1, coordinate2);
        Assert.assertNotEquals(coordinate1, coordinate3);

        Assert.assertEquals(1001, coordinate1.hashCode());
        Assert.assertTrue(coordinate1.equals(coordinate2));
        Assert.assertFalse(coordinate1.equals(coordinate3));

        final Coordinate coordinateGo = coordinate1.go(Direction.RIGHT);
        Assert.assertEquals(2, coordinateGo.getX());
        Assert.assertEquals(1, coordinateGo.getY());
    }

    @Test
    public void findPath0() throws IOException {
        final Maze maze = new Maze("src/test/resources/maze0.txt");
        Assert.assertNull(maze.findPath(new Coordinate(1, 1), new Coordinate(3, 1)));
    }

    @Test
    public void findPath1() throws IOException {
        final Maze maze = new Maze("src/test/resources/maze1.txt");
        final List<PathStep> path = maze.findPath(new Coordinate(1, 1), new Coordinate(8, 2));
        Assert.assertNotNull(path);
        Assert.assertEquals(8, path.size());
        System.out.println(maze.printWithPath(path));
    }

    @Test
    public void findPath2() throws IOException {
        final Maze maze = new Maze("src/test/resources/maze2.txt");
        final List<PathStep> path = maze.findPath(new Coordinate(1, 1), new Coordinate(8, 5));
        Assert.assertNotNull(path);
        Assert.assertEquals(25, path.size());
        System.out.println(maze.printWithPath(path));
    }

}
