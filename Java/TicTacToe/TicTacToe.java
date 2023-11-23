import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static String[][] board = {{" ", " ", " "},
                                       {" ", " ", " "},
                                       {" ", " ", " "}};
    private static String userTeam = " ";
    private static String cpuTeam = " ";
    private static String winner = " ";

    private static final Scanner SC = new Scanner(System.in);  

    public static void main(String[] args) {
        // Initialise Game        
        int turn = chooseTeam();

        System.out.println("===============");
        while (isGameOver()) {

            nextTurn(turn++);
            printBoard();
        }

    }

    private static int chooseTeam() {
        while (true) {
            System.out.print("Enter Team (X or O): ");
            String input = SC.nextLine();
    
            if ("X".equals(input)) {
                userTeam = "X";
                cpuTeam = "O";
                return -1;
            } else if ("O".equals(input)) {
                userTeam = "O";
                cpuTeam = "X";
                return 0;
            } else {
                System.out.println("Wrong Input! Try Again");
            }
        }
    }
    

    private static void nextTurn(int turn) {
        if (turn % 2 == 0) {
            userTurn();
        } else {
            cpuTurn();
        }

    }

    private static void userTurn() {
        while (true) {
            try {
                System.out.print("Enter Position: ");
                String stringPos = SC.nextLine();
                int result = Integer.parseInt(stringPos);
                if (applyIfValid(result)) {
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong Input! Try Again");
            }
        }
    }

    private static void cpuTurn() {
        System.out.println("CPU's Response:");
        while (true) {
            int result = getRandomNumberInRange(1, 9);
            if (applyIfValid(result)) {
                return;
            }
        }
    }

    private static boolean applyIfValid(int pos) {
        int count = 0;
        for (int row = 1; row <= 3; row++) {
            for (int column = 1; column <= 3; column++) {
                count++;
                if (count == pos && " ".equals(board[row][column])) {
                    board[row][column] = userTeam;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isGameOver() {
        return checkRows(board) || checkColumns(board) || checkDiagonals(board) || isBoardFull(board);
    }

    private static boolean checkRows(String[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].equals(" ")) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumns(String[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && !board[0][i].equals(" ")) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonals(String[][] board) {
        if ((board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals(" ")) ||
            (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].equals(" "))) {
            return true;
        }
        return false;
    }

    private static boolean isBoardFull(String[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(" ")) {
                    return false; // If there is an empty space, the board is not full
                }
            }
        }
        return true; // All spaces are filled, and no winner found
    }

    private static void printBoard() {

        System.out.println(board[0][0]+" | "+board[0][1]+" | "+board[0][2]);
        System.out.println("--+---+---");
        System.out.println(board[1][0]+" | "+board[1][1]+" | "+board[1][2]);
        System.out.println("--+---+---");
        System.out.println(board[2][0]+" | "+board[2][1]+" | "+board[2][2]);

        System.out.println("");
        System.out.println("===============");
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }

        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}