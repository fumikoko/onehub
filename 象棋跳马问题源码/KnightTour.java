import java.util.Scanner;

public class KnightTour {
    private static int X;
    private static int Y;
    private static int[][] chessBoard;
    private static boolean finished;
    private static int[] xMoves = {2, 1, -1, -2, -2, -1, 1, 2};
    private static int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the chessboard: ");
        X = scanner.nextInt();
        Y = X;
        chessBoard = new int[X][Y];
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                chessBoard[i][j] = -1;
            }
        }
        chessBoard[0][0] = 0;
        if (!solve(0, 0, 1)) {
            System.out.println("No solution found.");
        } else {
            printSolution();
        }
    }

    private static boolean solve(int x, int y, int moveCount) {
        if (moveCount == X * Y) {
            finished = true;
            return true;
        }
        for (int i = 0; i < xMoves.length; i++) {
            int nextX = x + xMoves[i];
            int nextY = y + yMoves[i];
            if (isValidMove(nextX, nextY)) {
                chessBoard[nextX][nextY] = moveCount;
                if (solve(nextX, nextY, moveCount + 1)) {
                    return true;
                } else {
                    chessBoard[nextX][nextY] = -1;
                }
            }
        }
        return false;
    }

    private static boolean isValidMove(int x, int y) {
        if (x >= 0 && x < X && y >= 0 && y < Y && chessBoard[x][y] == -1) {
            return true;
        }
        return false;
    }

    private static void printSolution() {
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
}
