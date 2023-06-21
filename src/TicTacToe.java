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
            do {
                display();
                col = SafeInput.getRangedInt(in, "Enter what column you want to move in", 0, 2);
                row = SafeInput.getRangedInt(in, "Enter what column you want to move in", 0, 2);
                board[col][row] = player;
                System.out.println(board[col][row]);

                if (player == "X")
                {
                    player = "Y";
                }
                else
                {
                    player = "X";
                }
            } while (isValidMove(row, col));
        }
        while (play);

        win = isWin(player);
    }

    private static void clearBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = " ";
            }
        }
    } //sets board elements to a space

    private static void display() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                System.out.println(board[row][col] + " | ");
            }
        }
        in.nextLine();
    } //shows tictactoe game for next movement

    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
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