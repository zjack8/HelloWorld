import java.util.Scanner;

public class TicTacToe {

    private static String[][] board = {{" ", " ", " "},
                                       {" ", " ", " "},
                                       {" ", " ", " "}};
    private static String userTeam = " ";
    private static String cpuTeam = " ";
    private static boolean gameOn = true;
    private static String winner = " ";

    private static final Scanner SC = new Scanner(System.in);  

    public static void main(String[] args) {
        // Initialise Game        
        int turn = chooseTeam();

        while (gameOn) {

            nextTurn(turn++);
            printBoard();
            
            gameOn = isGameOver();
        }

    }

    private static int chooseTeam() {
        System.out.print("Enter Team (X or O): ");
        String input = SC.nextLine();

        if (input == "X") {
            userTeam = "X";
            cpuTeam = "O";
            return -1;
        } else if (input == "O") {
            userTeam = "O";
            cpuTeam = "X";
            return 0;
        } else {
            System.out.println("Wrong Input! Try Again");
            return chooseTeam();
        }
    }

    private static void nextTurn(int turn) {
        int pos = 0;
        if (turn % 2 == 0) {
            pos = userTurn();
        } else {
            pos = cpuTurn();
        }

        int count = 0;
        for (int row = 1; row <= 3; row++) {
            for (int column = 1; column <= 3; column++) {
                count++;
                if (count == pos) {
                    board[row][column] = userTeam;
                }
            }
        }
    }

    private static int userTurn() {

        System.out.print("Enter Position: ");
        String stringPos = SC.nextLine();

        try {
            int result = Integer.parseInt(stringPos);
            return result;
        } catch (NumberFormatException e) {
            System.out.println("Wrong Input! Try Again");
            return userTurn();
        }
        
    }

    private static int cpuTurn() {
        // TODO
        System.out.println("CPU's Response:");
        return 1;

    }

    private static boolean isGameOver() {
        // TODO
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {

            }
        }
        return false;

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


}