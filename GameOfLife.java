import java.util.Scanner;

public class GameOfLife {
    public static void main(String[] args){
        boolean[][] world = genWorld(10);
        Scanner s = new Scanner(System.in);

        printWorld(world);
        while(s.nextLine().length() == 0) {
            world = nextGen(world);
            printWorld(world);
        }
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
        int numRows = world.length;
        int numCols = world[0].length;
        int num;
        boolean[][] newWorld = new boolean[numRows][numCols];

        for(int r = 0; r < numRows; r++) {
            for(int c = 0; c < numCols; c++) {
                num = numNeighbors(world, r, c);
                newWorld[r][c] = survivesThisGen(world[r][c], num);
            }
        }
        return world;
    };

    private static int numNeighbors(boolean[][] world, int r, int c) {
        boolean isEntity = world[r][c];
        int num = isEntity ? -1 : 0;
        int dimension = world.length;

        for(int i = r-1; i <= r+1; i++) {
            for(int j = c-1; j <= j+1; j++) {
                if(indexInBounds(dimension, i, j) && world[i][j]) {
                    num++;
                }
            }
        }
        return num;
    };

    private static boolean indexInBounds(int dimension, int r, int c) {
        return ((r >= 0 && r < dimension) && (c >= 0 && c < dimension));
    };

    private static boolean survivesThisGen(boolean isEntity, int numNeighbors) {
        if((isEntity && (numNeighbors == 2 || numNeighbors == 3)) || (!isEntity && numNeighbors == 3)) {
            return true;
        } else {
            return false;
        }
    };
}