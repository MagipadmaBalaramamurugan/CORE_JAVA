import java.util.Scanner;
public class tictactoe {
    private static final int SIZE = 3;
    private static char[][] board = new char[SIZE][SIZE];
    public static void main(String[] args) {
        initBoard();
        Scanner sac = new Scanner(System.in);
        char currentPlayer = 'X';
        int moves = 0;
        System.out.println("Tic-Tac-Toe");
        printBoard();
        while (true) {
            System.out.println("Player " + currentPlayer + ", Enter the row and column (1-3): ");
            System.out.println("Row");
            int row = sac.nextInt() - 1;
            System.out.println("Column");
            int col = sac.nextInt() - 1;
            if (!isValidMove(row, col)) {
                System.out.println("Invalid move! Try again.");
            }
            board[row][col] = currentPlayer;
            moves++;
            printBoard();
            if (checkWin(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }
            if (moves == SIZE * SIZE) {
                System.out.println("It's a draw!");
                break;
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }
    private static void initBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }
    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == ' ';
    }
    private static boolean checkWin(char player) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
        }
        for (int j = 0; j < SIZE; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }
}
