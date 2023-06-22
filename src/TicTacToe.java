import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];
    private static int move = 0;
    private static boolean win = false;

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean play = true;
        String player = "";
        move = 0;
        do {
            clearBoard();
            int col;
            int row;
            player = "X";
            boolean valid;
            boolean tie = false;
            do {
                play = false;
                display();
                do {
                    row = SafeInput.getRangedInt(in, "Enter what row you want to move in", 1, 3);
                    col = SafeInput.getRangedInt(in, "Enter what column you want to move in", 1, 3);
                    row = row - 1;
                    col = col - 1;
                    valid = isValidMove(col, row);
                } while (!valid);
                move = move + 1;
                System.out.println("Move " + move);
                if (move % 2 == 0)
                {
                    board[col][row] = "Y";
                }
                else
                {
                    board[col][row] = "X";
                }
                if (isWin(player) == true)
                {
                    System.out.println("Player " + player + " has won.");
                    win = true;
                }
                else if (isTie() == true)
                {
                    System.out.println("It is a tie.");
                    tie = true;
                }
            } while (!win || !tie);
            play = SafeInput.getYNConfirm(in, "Play again? Y/N");
        }
        while (play);

        win = isWin(player);
    }

    private static void clearBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[col][row] = " ";
            }
        }
    } //sets board elements to a space

    private static void display() {
        System.out.println(board[0][0] + "|" + board[1][0] + "|" + board[2][0]);
        System.out.println("-----");
        System.out.println(board[0][1] + "|" + board[1][1] + "|" + board[2][1]);
        System.out.println("-----");
        System.out.println(board[0][2] + "|" + board[1][2] + "|" + board[2][2]);
        in.nextLine();
    } //shows tictactoe game for next movement

    private static boolean isValidMove(int col, int row) {
        if (board[col][row].equals(" "))
        {
            return true;
        }
        else
        {
            System.out.println("Not a legal move, please enter a legal move.");
            return false;
        }
    }

    private static boolean isWin(String player) {
        if (isColWin(player) || isRowWin(player) || isDiagnalWin(player)) {
            return true;
        }
        return false;
    }

    private static boolean isRowWin(String player) {
        for (int row = 0; row < ROW; row++) {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagnalWin(String player) {
        for (int col = 0; col < COL; col++) {
            for (int row = 0; row < ROW; row++) {
                if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
                    return true;
                } else if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for (int col = 0; col < COL; col++) {
            if (board[col][0].equals(player) && board[col][1].equals(player) && board[col][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isTie()
    {
        if (move == 9 && !win)
        {
            return true;
        } else if (move >= 7 && !win)
        {
            for (int col = 0; col < COL; col++)
            {
                for (int row = 0; row < ROW; row++)
                {
                    if ((board[col][0].equals("X") && board[col][0].equals("Y") || (board[col][1].equals("X") && board[col][1].equals("Y") || (board[col][2].equals("X") && board[col][2].equals("Y") || board[0][0].equals("Y") && board[1][1].equals("X") || board[0][0].equals("X") && board[1][1].equals("Y") || board[0][2].equals("X") && board[1][1].equals("Y") || board[0][2].equals("Y") && board[1][1].equals("X")) || board[row][0].equals("X") && board[row][0].equals("Y") || (board[row][1].equals("X") && board[row][1].equals("Y") || (board[row][2].equals("X") && board[row][2].equals("Y"))))))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}