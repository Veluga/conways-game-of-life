import java.util.Scanner;

public class GameOfLife {
    public static void main(String[] args){};

    private static void printWorld(boolean[][] world) {};

    private static boolean[][] genWorld(int dimension) {
        return new boolean[dimension][dimension];
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