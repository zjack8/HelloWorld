import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static String[][] board = {{" ", " ", " "},
                                       {" ", " ", " "},
                                       {" ", " ", " "}};
    private static String userTeam = "-";
    private static String cpuTeam = "-";
    private static String winner = "-";

    private static final Scanner SC = new Scanner(System.in);  

    public static void main(String[] args) {
        // Initialise Game        
        int turn = chooseTeam();

        System.out.println("===============");
        while (!isWinner()) {
            nextTurn(turn++);
            printBoard();
            System.out.println("===============");
        }

        System.out.println(getWinner());
    }

    private static int chooseTeam() {
        while (true) {
            System.out.print("Enter Team (X or O): ");
            String input = SC.nextLine();
    
            if ("X".equals(input)) {
                userTeam = "X";
                cpuTeam = "O";
                return 0;
            } else if ("O".equals(input)) {
                userTeam = "O";
                cpuTeam = "X";
                return -1;
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
                if (applyIfValid(result, userTeam)) {
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
            if (applyIfValid(result, cpuTeam)) {
                return;
            }
        }
    }

    private static boolean applyIfValid(int pos, String team) {
        int count = 0;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                count++;
                if (count == pos && " ".equals(board[row][column])) {
                    board[row][column] = team;
                    return true;
                }
            }
        }
        return false;
    }

    private static String getWinner() {
        if (winner.equals(userTeam)) {
            return "The User Wins!!!";
        } else if (winner.equals(cpuTeam)) {
            return "The CPU Wins!!!";
        } else {
            return "There is no Winner!";
        }
    }

    private static boolean isWinner() {
        if (checkRows(board) || checkColumns(board) || checkDiagonals(board)) {
            return true;
        }

        if (isBoardFull(board)) {
            winner = "-";
            return true;
        }

        return false;
    }

    private static boolean checkRows(String[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].equals(" ")) {
                winner = board[i][0];
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumns(String[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && !board[0][i].equals(" ")) {
                winner = board[0][i];
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonals(String[][] board) {
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals(" ")) {
            winner = board[0][0];
            return true;
        } else if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].equals(" ")) {
            winner = board[0][2];
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
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }

        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}