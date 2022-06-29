import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static final int ROAD = 0;
    public static final int WALL = 1;

    public enum DIRECTION {
        UP, DOWN, LEFT, RIGHT
    }

    public static class Coordinate {
        public int x;
        public int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * The method for you to implement.
     */
    public List<DIRECTION> explore(int[][] maze, Coordinate start, Coordinate end) {
        List<DIRECTION> result = new ArrayList<>();
        // TODO
        List<Coordinate> path = new ArrayList<>();
        if(isPath(maze, start.x, start.y, path, end)) {
            for(int i=0; i<path.size()-1; i++) {
                DIRECTION newDir = convert(path.get(i), path.get(i+1));
                result.add(newDir);
            }
            return result;
        }
        return null;
    }

    public DIRECTION convert(Coordinate p1, Coordinate p2) {
        if(p1.x == p2.x && p1.y == p2.y+1) {
            return DIRECTION.LEFT;
        }
        if(p1.x == p2.x && p1.y == p2.y-1) {
            return DIRECTION.RIGHT;
        }
        if(p1.x == p2.x+1 && p1.y == p2.y) {
            return DIRECTION.UP;
        }
        return DIRECTION.DOWN;
    }

    public boolean isPath(int[][] maze, int row, int col, List<Coordinate> path, Coordinate end) {
        int[][] dir = {{0,1}, {1,0}, {0, -1}, {-1, 0}};

        if(!isValidPoint(row, col, maze) || maze[row][col] == WALL) {
            return false;
        }
        path.add(new Coordinate(row, col));
        maze[row][col] = WALL;
        if(row == end.x && col == end.y) {
            return true;
        }
        for(int[] d : dir) {
            Coordinate cor = getNextPoint(row, col, d[0], d[1]);
            if(isPath(maze, cor.x, cor.y, path, end)) {
                return true;
            }
        }

        path.remove(path.size()-1);
        return false;
    }

    public boolean isValidPoint(int row, int col, int[][] maze) {
        if(row < 0 || row >= maze.length || col < 0 || col >= maze[0].length) {
            return false;
        }
        return true;
    }

    public Coordinate getNextPoint(int row, int col, int i, int j) {
        return new Coordinate(row+i, col+j);
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0},
        };
        Solution solution = new Solution();
        System.out.println(solution.explore(maze, new Coordinate(0, 1), new Coordinate(3, 4))); // Should be [DOWN, RIGHT, RIGHT, DOWN, DOWN, RIGHT]
    }
}