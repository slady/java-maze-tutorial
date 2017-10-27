package ps.java.tutorial.maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

}
