import java.util.Scanner;

public class GameOfLife {
    public static void main(String[] args){
        boolean[][] world = genWorld(10);
        printWorld(world);
    };

    private static void printWorld(boolean[][] world) {
        int numRows = world.length;
        int numCols = world[0].length;

        for(int r = 0; r < numRows; r++) {
            for(int c = 0; c < numCols; c++) {
                if(world[r][c]) {
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    };

    private static boolean[][] genWorld(int dimension) {
        boolean[][] world = new boolean[dimension][dimension];

        for(int r = 0; r < dimension; r++) {
            for(int c = 0; c < dimension; c++) {
                if(Math.random() < 0.5) {
                    world[r][c] = true;
                }
            }
        }
        return world;
    };

    private static boolean[][] nextGen(boolean[][] world) {
        return new boolean[world.length][world[0].length];
    };

    private static int numNeighbors() {
        return 0;
    };

    private static boolean indexInBounds(boolean[][] world, int r, int c) {
        return true;
    };

    private static boolean survivesThisGen(boolean isEntitiy, int numNeighbors) {
        return true;
    };
}